package Interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TicketSystem  implements TicketMaster{
    Map<Integer, Ticket> ticketMap = new HashMap<>();
    private Queue<Ticket> open = new LinkedList<>();   //change to queue
    private Queue<Ticket> inProgress = new LinkedList<>();
    private Queue<Ticket> resolved = new LinkedList<>();
    private Queue<Ticket> closed = new LinkedList<>();



    ///assign ticket to employee
    //assign ticket for review



    public Ticket createTicket(String type , String Description){
        Ticket ticket = new Ticket(getTicketType(type),Description,Status.OPEN);
        ticket.setId(ticket.hashCode());
        ticketMap.put(ticket.getId(),ticket);
        proceesTicket(ticket);
        return  ticket;
    }


    public void proceesTicket( Ticket ticket){
        if(ticket.getType() == TicketType.CHECK_WALLET_BALANCE){
            ticket.setStatus(Status.CLOSED);
            closed.add(ticket);
        }else{
            open.add(ticket);
        }
    }





    private TicketType getTicketType(String ticketType){
        TicketType type = null;
        if("check-wallet-balance".equals(ticketType)){
          return TicketType.CHECK_WALLET_BALANCE;
        }else if("change-language".equals(ticketType)){
            return TicketType.CHANGE_LANGUAGE;
        }else{
            return TicketType.OTHER;
        }

    }



    public Ticket assignTicket(String empName){
        Employee employee = EmployeeMananger.getEmployeeByName(empName);
        if(null == employee){
            //throw an error
        }
        Ticket ticket = null;
       if(employee.getEmpType() == EmpType.GENERAL){
           ticket = open.poll();
           inProgress.add(ticket);
       } else if (employee.getEmpType() == EmpType.GENERAL){
           ticket = resolved.poll();
           closed.add(ticket);
       }
        employee.setTicket(ticket);
       return ticket;
    }

    @Override
    public Ticket resolveTicket(String empName, String resolution) {
        Employee employee = EmployeeMananger.getEmployeeByName(empName);
        if(null == employee){
            //throw an error
        }
        Ticket ticket = employee.getTicket();
        ticket.getActions().add(resolution);
        ticket.setStatus(Status.RESOLVED);
        //remove from inprogress
        removeFromQueue(inProgress,ticket);
        resolved.add(ticket);
        return ticket;
    }

    @Override
    public Ticket verifyTicket(String empName) {
        Employee employee = EmployeeMananger.getEmployeeByName(empName);
        if(null == employee){  //also check if he is an supervisor
            //throw an error
        }
        Ticket ticket = employee.getTicket();
        ticket.setStatus(Status.CLOSED);
        removeFromQueue(resolved,ticket);
        closed.add(ticket);
        return ticket;
    }

    @Override
    public void status() {
        System.out.println(open.size()+"- OPEN TICKETS");
        System.out.println(inProgress.size()+"- ASSIGNED TICKETS");
        System.out.println(closed.size()+"- CLOSED TICKETS");
        System.out.println(ticketMap.size()+"- TOTAL TICKETS");

    }

    @Override
    public void status(int ticketNum) {
        Ticket ticket = ticketMap.get(ticketNum);
        System.out.println("Ticket-"+ticket.getId()+ " status: "+ticket.getStatus()+" comment: "+ticket.getActions()
        + " resolved-by:"+ticket.getAssigned().getName() + " verified-by: "+ ticket.getReviewer().getName());
    }


    private void removeFromQueue(Queue<Ticket> queue,Ticket ticket){
        while(queue.iterator().hasNext()){
            Ticket localTicket = queue.iterator().next();
            if(localTicket.equals(ticket)){
                queue.iterator().remove();
                return;
            }
        }

     }



  /*  public Ticket assignTicket(Employee employee){
        switch (employee.getEmpType()){
            case EmpType.SUPERVISOR:
                //code to be executed;
                break;  //optional
          *//*  case EmpType.SUPERVISOR:
                //code to be executed;
                break;*//*
            default:
        }

    }*/



}
