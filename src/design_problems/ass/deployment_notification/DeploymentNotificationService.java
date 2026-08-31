package design_problems.ass.deployment_notification;

import java.util.*;

public class DeploymentNotificationService {

    public static void main(String[] args) {
        DeploymentNotificationService service = new DeploymentNotificationService();

        // Simulate events
        service.handleEvent(new DeploymentEvent("v1", Set.of("Alice", "Bob"), Status.STARTED));
        service.handleEvent(new DeploymentEvent("v1", Set.of("Alice", "Bob"), Status.FAILED));

        service.handleEvent(new DeploymentEvent("v2", Set.of("Alice", "Bob", "Charlie"), Status.STARTED));
        service.handleEvent(new DeploymentEvent("v2", Set.of("Alice", "Bob", "Charlie"), Status.COMPLETED));

        service.handleEvent(new DeploymentEvent("v3", Set.of("Alice", "Bob", "Charlie", "Dave"), Status.STARTED));
        service.handleEvent(new DeploymentEvent("v3", Set.of("Alice", "Bob", "Charlie", "Dave"), Status.COMPLETED));

        // Send batch notifications
        service.sendNotifications();
    }
    //private final Map<String, DeploymentEvent> versionEvents = new HashMap<>();//not need really
    private final Set<String> notifiedAuthors = new HashSet<>();
    private final List<DeploymentNotification> pendingNotifications = new ArrayList<>();

    public void handleEvent(DeploymentEvent event) {

        if (event == null || event.version == null || event.authors == null || event.status == null) {
            System.out.println("[WARN] Ignored malformed event: " + event);
            return;
        }
       // versionEvents.put(event.version,event);
        if (event.status == Status.COMPLETED) {
           for (String author :event.authors){
               if(!notifiedAuthors.contains(author)){
                   pendingNotifications.add(new DeploymentNotification(author,event.version));
                   notifiedAuthors.add(author);
               }
           }
        }
    }




    public void handleEventNew(DeploymentEvent event) {
        if(event == null || event.status == null || event.version == null) {
            System.out.println("[WARN] Ignored malformed event: " + event);
            return;
        }
        if(event.status == Status.COMPLETED){
            for (String author : event.authors){
                if(!notifiedAuthors.contains(author)){
                    pendingNotifications.add(new DeploymentNotification(event.version,author));
                    notifiedAuthors.add(author);
                }
            }
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

}
