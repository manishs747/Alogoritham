package Interview;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private TicketType type;
    private String description;
    private List<String> actions = new ArrayList<>();
    private Status status;
    private Employee assigned;
    private Employee reviewer;



    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getAssigned() {
        return assigned;
    }

    public void setAssigned(Employee assigned) {
        this.assigned = assigned;
    }

    public Employee getReviewer() {
        return reviewer;
    }

    public void setReviewer(Employee reviewer) {
        this.reviewer = reviewer;
    }



    public Ticket( TicketType type, String description, Status status) {
        if(description != null && description.length() > 500){
            throw new RuntimeException("Invalid Descriotion");
        }

        this.type = type;
        this.description = description;
        this.status = status;
    }
}
