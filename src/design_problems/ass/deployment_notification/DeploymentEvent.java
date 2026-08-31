package design_problems.ass.deployment_notification;

import java.util.Set;

public class DeploymentEvent {
    public String version;
    public Set<String> authors;
    public Status status;

    public DeploymentEvent(String version, Set<String> authors, Status status) {
        this.version = version;
        this.authors = authors;
        this.status = status;
    }
}
