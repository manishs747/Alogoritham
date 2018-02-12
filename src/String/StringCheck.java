package String;

public class StringCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = confirmPaymentStatus("not ", false);
        System.out.println(result);
		
	}
	
	public static String confirmPaymentStatus(String paymentDetails, boolean paymentStatus) {
        if (paymentStatus) {
            return "SUCCESS";
        } else {
            if (paymentDetails.equalsIgnoreCase("pending")) {
                return "PENDING";
            } else {
                return "FAILURE";
            }
        }
    }

}
