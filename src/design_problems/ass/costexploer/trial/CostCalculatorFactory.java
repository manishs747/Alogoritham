package design_problems.ass.costexploer.trial;

public class CostCalculatorFactory {
    public static ICostCalculator getCalculator(Subscription subscription) {
        if (subscription.getPlan() == Plan.TRIAL) {
            return TrialCostCalculator.getInstance();
        }
        return RegularCostCalculator.getInstance();
    }
}
