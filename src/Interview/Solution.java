package Interview;

public class Solution {
    TicketMaster ticketMaster = new TicketSystem();

    public static void main(String[] args) {

        Solution solution = new Solution();
        EmployeeMananger.enrichEmployee();

        /*create-ticket check-wallet-balance status 1*/
       // solution.ticketMaster.createTicket("check-wallet-balance",null);


        solution.processCommand("create-ticket" ,"check-wallet-balance",null);

        /*create-ticket check-wallet-balance status 1
        create-ticket change-language status 2
        create-ticket others Need more details on transaction #abc assign-ticket tom
        resolve-ticket tom Resolved transaction issue #abc
        status 3status
        verify-ticket-resolution Harry // report error as shown below in the sample status
        verify-ticket-resolution Harry // report error as shown below in the sample assign-ticket Harry
        verify-ticket-resolution Harry status 3
        status*/

    }



    public void  processCommand(String commandType ,  String  type, String description){
        if(commandType.equals("create-ticket")){
            Ticket ticket = ticketMaster.createTicket("check-wallet-balance", null);
            System.out.println(ticket.getStatus());

        }else if(commandType.equals("status")){

        }else{

        }

    }



}
