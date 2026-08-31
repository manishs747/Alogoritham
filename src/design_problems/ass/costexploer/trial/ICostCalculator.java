package design_problems.ass.costexploer.trial;

import java.time.LocalDate;
import java.util.List;

public interface ICostCalculator {
    List<Double> monthlyCostList(Subscription subscription, LocalDate unitYearStart);
    double annualCost(Subscription subscription, LocalDate unitYearStart);
}
