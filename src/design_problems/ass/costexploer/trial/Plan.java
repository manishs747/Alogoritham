package design_problems.ass.costexploer.trial;

public enum Plan {
    TRIAL(0.0),
    BASIC(9.99),
    STANDARD(49.99),
    PREMIUM(249.99);

    private final double monthlyCost;
    Plan(double cost) { this.monthlyCost = cost; }
    public double getMonthlyCost() { return monthlyCost; }
}
