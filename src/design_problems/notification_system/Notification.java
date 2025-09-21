package design_problems.notification_system;

public class Notification implements Comparable<Notification>{

    private final String userId;
    private final String message;
    private final ChannelType channelType;
    private final Priority priority;

    public Notification(String userId, String message, ChannelType channelType, Priority priority) {
        this.userId = userId;
        this.message = message;
        this.channelType = channelType;
        this.priority = priority;
    }

    public String getUserId() { return userId; }
    public String getMessage() { return message; }
    public ChannelType getChannelType() { return channelType; }
    public Priority getPriority() { return priority; }

    @Override
    public int compareTo(Notification other) {
        return this.priority.compareTo(other.priority); // High processed first
    }

}
