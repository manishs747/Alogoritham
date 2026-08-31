package design_problems.ass.costexploer;

public class Plan {
    private final String planId;
    private final double monthlyCost;

    public Plan(String planId, double monthlyCost) {
        if (monthlyCost < 0 || planId == null || planId.isEmpty()) throw new IllegalArgumentException("Invalid Plan");
        this.planId = planId;
        this.monthlyCost = monthlyCost;
    }
    public String getPlanId() { return planId; }
    public double getMonthlyCost() { return monthlyCost; }
}
