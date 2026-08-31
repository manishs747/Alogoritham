package design_problems.ass.deployment_notification.no_ordering;


import design_problems.ass.deployment_notification.DeploymentEvent;
import design_problems.ass.deployment_notification.DeploymentNotification;
import design_problems.ass.deployment_notification.Status;

import java.util.*;

/**
 * 1. Immediate Notification with Available Information ✅ (simplest, lowest latency)
 *
 * Notify as soon as a COMPLETED event arrives.
 * If v2 COMPLETED arrives before v1 FAILED, notify v2 authors immediately.
 * If later v1 FAILED arrives, when v3 succeeds, retroactively include v1 authors there.
 *
 * Pros:
 * Fastest communication (developers notified quickly).
 * Simple to implement (only track seen versions).
 *
 * Cons:
 * Notifications may later be “corrected” or adjusted (slightly confusing).
 * Requires retroactive reconciliation.
 */
public class DeploymentNotificationServiceNoOrdering {

    private final Set<String> notifiedAuthors = new HashSet<>();
    private final List<DeploymentNotification> pendingNotifications = new ArrayList<>();
    private final Map<String, DeploymentEvent> versionEvents = new HashMap<>();

    // Track failures waiting for a success
    private final Set<String> unnotifiedAuthors = new HashSet<>();

    public void handleEvent(DeploymentEvent event) {
        versionEvents.put(event.version, event);
        switch (event.status) {
            case FAILED:
                unnotifiedAuthors.addAll(event.authors);
                break;

            case COMPLETED:

                // Authors in this version (including unnotified ones from previous failures)
                Set<String> effectiveAuthors = new HashSet<>(event.authors);
                effectiveAuthors.addAll(unnotifiedAuthors);
                for (String author : effectiveAuthors) {
                    if (!notifiedAuthors.contains(author)) {
                        pendingNotifications.add(new DeploymentNotification(author, event.version));
                        notifiedAuthors.add(author);
                    }
                }
                // Clear unnotified (they’ve now been covered)
                unnotifiedAuthors.clear();
                break;
            default:
                // STARTED / REVERTED ignored for now
                break;
        }
    }

    public void sendNotifications() {
        if (pendingNotifications.isEmpty()) {
            System.out.println("No new notifications.");
            return;
        }
        for (DeploymentNotification n : pendingNotifications) {
            System.out.println(n);
        }
        pendingNotifications.clear();
    }

    public static void main(String[] args) {
        DeploymentNotificationServiceNoOrdering service = new DeploymentNotificationServiceNoOrdering();

        // Out-of-order arrival
        service.handleEvent(new DeploymentEvent("v2", Set.of( "Bob"), Status.COMPLETED));
        service.sendNotifications();
        // Notifies Alice & Bob (immediate feedback)

        service.handleEvent(new DeploymentEvent("v1", Set.of("Alice"), Status.FAILED));
        service.handleEvent(new DeploymentEvent("v3", Set.of("Alice", "Bob", "Charlie"), Status.COMPLETED));
        service.sendNotifications();
        // Now, because v1 failed and v3 succeeded, Alice is properly accounted for in v3
        // Charlie notified at v3
    }



}
