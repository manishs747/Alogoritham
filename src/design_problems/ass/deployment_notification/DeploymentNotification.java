package design_problems.ass.deployment_notification;

public class DeploymentNotification {
    public String author;
    String version;

    public DeploymentNotification(String author, String version) {
        this.author = author;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Notify " + author + " for version " + version;
    }

}
