package design_problems.ass.costexploer.trial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrialCostCalculator implements ICostCalculator{
    private static final TrialCostCalculator INSTANCE = new TrialCostCalculator();
    private TrialCostCalculator() {}
    public static TrialCostCalculator getInstance() { return INSTANCE; }

    @Override
    public List<Double> monthlyCostList(Subscription subscription, LocalDate unitYearStart) {
        double[] costs = new double[12];
        LocalDate trialEnd = subscription.getEndDate();
        Plan afterTrialPlan = subscription.getPlanAfterTrial();

        // Step 1: Fill 0 for trial period
        LocalDate subStart = subscription.getStartDate();
        for (int i = 0; i < 12; i++) {
            LocalDate monthStart = unitYearStart.plusMonths(i);
            LocalDate monthEnd = monthStart.withDayOfMonth(monthStart.lengthOfMonth());

            if (subStart.isAfter(monthEnd)) continue;

            if (trialEnd != null && trialEnd.isBefore(monthEnd)) {
                // After trial ends → delegate to regular cost calculator with afterTrialPlan
                Subscription upgraded = new Subscription(subscription.getProduct(), afterTrialPlan, trialEnd.plusDays(1), null, null);
                List<Double> postTrial = RegularCostCalculator.getInstance().monthlyCostList(upgraded, unitYearStart);
                for (int j = 0; j < 12; j++) costs[j] += postTrial.get(j);
                break;
            }
        }

        List<Double> result = new ArrayList<>();
        for (double c : costs) result.add(c);
        return result;
    }

    @Override
    public double annualCost(Subscription subscription, LocalDate unitYearStart) {
        return monthlyCostList(subscription, unitYearStart).stream().mapToDouble(Double::doubleValue).sum();
    }
}
