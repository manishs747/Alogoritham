package Interview;

public class Employee {
    private String name;
    private EmpType empType;

    public Employee(String name, EmpType empType) {
        this.name = name;
        this.empType = empType;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private Ticket  ticket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmpType getEmpType() {
        return empType;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }
}
