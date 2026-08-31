package design_problems.ass.deployment_notification.reverted;

import design_problems.ass.deployment_notification.DeploymentEvent;
import design_problems.ass.deployment_notification.DeploymentNotification;
import design_problems.ass.deployment_notification.Status;

import java.util.*;

public class DeploymentNotificationService {
    private final Set<String> notifiedAuthors = new HashSet<>();
    private final List<DeploymentNotification> pendingNotifications = new ArrayList<>();
    private final Set<String> revertedAuthors = new HashSet<>();//new


    private final Map<String, Set<String>> versionAuthors = new HashMap<>();  //not needed




    /**
     * Handled 3 revert scenarios:
     * Revert before deployment → no notification.
     * Revert after success + notified → no new notification (but old one stands).
     * Revert after success but not yet notified → pending removed.
     */
    public void handleEvent(DeploymentEvent event) {
        if (event == null || event.version == null || event.authors == null || event.status == null) {
            System.out.println("[WARN] Ignored malformed event: " + event);
            return;
        }

        switch (event.status){
            case STARTED:
            case FAILED:
                versionAuthors.put(event.version, event.authors);
                break;
            case COMPLETED:
                versionAuthors.put(event.version,event.authors);
                for (String author : event.authors) {
                    // skip if reverted or already notified
                    if(!notifiedAuthors.contains(author) && !revertedAuthors.contains(author)){ //extra check
                        pendingNotifications.add(new DeploymentNotification(author, event.version));
                        notifiedAuthors.add(author);
                    }
                }
                break;
            case REVERTED:
                // mark authors as reverted
                revertedAuthors.addAll(event.authors);
                // remove from pending notifications if they exist
                pendingNotifications.removeIf(n -> event.authors.contains(n.author));
                /*Iterator<DeploymentNotification> it = pendingNotifications.iterator();
                while (it.hasNext()) {
                    DeploymentNotification n = it.next();
                    if (event.authors.contains(n.author)) {
                        it.remove(); // safe removal while iterating
                    }*/
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
        DeploymentNotificationService service = new DeploymentNotificationService();

        // Case 1: revert before deployment
        service.handleEvent(new DeploymentEvent("v1", Set.of("Alice"), Status.STARTED));
        service.handleEvent(new DeploymentEvent("v1", Set.of("Alice"), Status.FAILED));
        service.handleEvent(new DeploymentEvent("v2", Set.of("Alice"), Status.REVERTED));
        service.handleEvent(new DeploymentEvent("v2", Set.of("Alice", "Bob"), Status.COMPLETED));
        // Case 2: revert after success
        service.handleEvent(new DeploymentEvent("v3", Set.of("Charlie"), Status.STARTED));
        service.handleEvent(new DeploymentEvent("v3", Set.of("Charlie"), Status.COMPLETED));
        service.sendNotifications(); // Charlie notified
        service.handleEvent(new DeploymentEvent("v4", Set.of("Charlie"), Status.REVERTED));
        service.handleEvent(new DeploymentEvent("v4", Set.of("Dave"), Status.COMPLETED));

        service.sendNotifications();
    }
}
