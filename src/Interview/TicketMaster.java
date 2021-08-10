package Interview;

public interface TicketMaster {





    //create-ticket <msg-type> <msg-desc>
    Ticket createTicket(String type , String Description);

    //assign-ticket <emp-name>
    Ticket assignTicket(String empName);


    //resolve-ticket <emp-name> <resolution-comment>
    Ticket resolveTicket(String empName,String resolution);


   // verify-ticket-resolution <supervisor-name>
    Ticket verifyTicket(String empName);


   // status <ticket-number>
    void status();


   // status <ticket-number>

    void status(int ticketNum);


}
