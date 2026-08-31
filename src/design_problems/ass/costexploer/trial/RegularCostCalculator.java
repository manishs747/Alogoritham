package design_problems.ass.costexploer.trial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegularCostCalculator implements ICostCalculator{

    private static final RegularCostCalculator INSTANCE = new RegularCostCalculator();
    private RegularCostCalculator() {}
    public static RegularCostCalculator getInstance() { return INSTANCE; }

    @Override
    public List<Double> monthlyCostList(Subscription subscription, LocalDate unitYearStart) {
        double[] costs = new double[12];
        double cost = subscription.getPlan().getMonthlyCost();

        LocalDate subStart = subscription.getStartDate();
        LocalDate subEnd = subscription.getEndDate() != null ? subscription.getEndDate() : unitYearStart.plusYears(1).minusDays(1);

        for (int i = 0; i < 12; i++) {
            LocalDate monthStart = unitYearStart.plusMonths(i);
            LocalDate monthEnd = monthStart.withDayOfMonth(monthStart.lengthOfMonth());

            if (subStart.isAfter(monthEnd) || subEnd.isBefore(monthStart)) continue;

            LocalDate activeStart = subStart.isAfter(monthStart) ? subStart : monthStart;
            LocalDate activeEnd = subEnd.isBefore(monthEnd) ? subEnd : monthEnd;

            long activeDays = java.time.temporal.ChronoUnit.DAYS.between(activeStart, activeEnd.plusDays(1));
            costs[i] = (activeDays / (double) monthStart.lengthOfMonth()) * cost;
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
