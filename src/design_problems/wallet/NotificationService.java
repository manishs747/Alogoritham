package design_problems.wallet;

public class NotificationService {

    public void sendNotification(User user, String message){
        System.out.println("Notify "+user.getUserId()+":"+message);
    }
}
