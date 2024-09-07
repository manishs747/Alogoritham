package online;

import java.util.*;

public class MessageDeliveryManager {


    private static class Message {
        int timestamp;
        String value;

        Message(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public List<String> getStatusMessage(List<Integer> timestamps, List<String> messages, int k) {
        Deque<Message> deliveredMessages = new LinkedList<>();
        List<String> statusMessages = new ArrayList<>();
        for (int i = 0; i < timestamps.size(); i++) {
            int currentTime = timestamps.get(i);
            cleanOldMessages(currentTime,k,deliveredMessages);
            if (shouldDropMessage(currentTime, messages.get(i),k,deliveredMessages)) {
                //statusMessages.add("Message dropped: " + messages.get(i));
                statusMessages.add("true");
            } else {
                deliveredMessages.offer(new Message(currentTime, messages.get(i)));
                //statusMessages.add("Message delivered: " + messages.get(i));
                statusMessages.add("false");
            }
        }
        return statusMessages;
    }

    private void cleanOldMessages(int currentTime,int k,Deque<Message> deliveredMessages) {
        while (!deliveredMessages.isEmpty() && (currentTime - deliveredMessages.peek().timestamp > k)) {
            deliveredMessages.poll();
        }
    }

    private boolean shouldDropMessage(int currentTime, String message ,int k,Deque<Message> deliveredMessages) {
        for (Message deliveredMessage : deliveredMessages) {
            if (currentTime - deliveredMessage.timestamp <= k && deliveredMessage.value.equals(message)) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int k = 5;
        List<Integer> timestamps = Arrays.asList(0, 3, 5, 11);  // Example timestamps in seconds
        List<String> messages = Arrays.asList("Message 1", "Message 1", "Message 3", "Message 1");

        MessageDeliveryManager manager = new MessageDeliveryManager();
        List<String> statusMessages = manager.getStatusMessage(timestamps, messages, k);

        for (String status : statusMessages) {
            System.out.println(status);
        }
    }
}
