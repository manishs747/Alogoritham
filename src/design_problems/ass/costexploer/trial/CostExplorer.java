package design_problems.ass.costexploer.trial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CostExplorer {
    private final List<Subscription> subscriptions;
    private final LocalDate unitYearStart;

    public CostExplorer(List<Subscription> subscriptions, int unitYearStartMonth, int year) {
        this.subscriptions = subscriptions;
        this.unitYearStart = LocalDate.of(year, unitYearStartMonth, 1);
    }

    public List<Double> monthlyCostList() {
        double[] total = new double[12];
        for (Subscription sub : subscriptions) {
            List<Double> subCosts = CostCalculatorFactory.getCalculator(sub)
                    .monthlyCostList(sub, unitYearStart);
            for (int i = 0; i < 12; i++) {
                total[i] += subCosts.get(i);
            }

        }
        List<Double> result = new ArrayList<>();
        for (double c : total) result.add(c);
        return result;
    }

    public double annualCost() {
        return monthlyCostList().stream().mapToDouble(Double::doubleValue).sum();
    }
}
