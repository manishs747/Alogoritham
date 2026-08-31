package design_problems.ass.costexploer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CostExplorer implements ICostExplorer{

    private final List<Subscription> subscriptions; //for multiple product have list of list subscriptions
    private final int unitYearStartMonth;//4

    public CostExplorer(List<Subscription> subscriptions, int unitYearStartMonth) {
        if (unitYearStartMonth < 1 || unitYearStartMonth > 12) throw new IllegalArgumentException("Unit year start must be between 1 and 12");
        this.subscriptions = subscriptions == null ? new ArrayList<>() : subscriptions;
        this.unitYearStartMonth = unitYearStartMonth;
    }




    @Override
    public List<Double> monthlyCostList() {
        Double[] monthlyCosts = new Double[12];
        for (Subscription sub:subscriptions){

            Plan plan = sub.getPlan();
            double plancost = plan.getMonthlyCost();
            LocalDate start = sub.getStartDate();
            // unit year boundaries
            /*
            start = 2022-07-15    unitYearStartMonth = 4
            unitYearStart = 2022-04-01  unitYearEnd = 2023-03-31
             */
            LocalDate unitYearStart = LocalDate.of(start.getYear(), unitYearStartMonth, 1); // unitYearStartMonth = 4
            LocalDate unitYearEnd = unitYearStart.plusYears(1).minusDays(1);

            // If subscription starts outside this unit year, skip
            if (start.isAfter(unitYearEnd)) continue;

            for (int i = 0; i < 12; i++) {
                double cost = plancost;
                LocalDate monthStart = unitYearStart.plusMonths(i);
                LocalDate monthEnd = monthStart.withDayOfMonth(monthStart.lengthOfMonth()); // last date of month
                if (start.isAfter(monthEnd)) continue; //
                if(start.isAfter(monthStart) && start.isBefore(monthEnd)){ // calculate per day cost
                    int daysInMonth = monthStart.lengthOfMonth();
                    int activeDays = daysInMonth - start.getDayOfMonth() + 1;
                    cost = (activeDays * (cost/daysInMonth));
                }
                monthlyCosts[i] += cost;
            }
        }
       return Arrays.asList(monthlyCosts);
    }




    @Override
    public double annualCost() {
        return monthlyCostList().stream().mapToDouble(Double::doubleValue).sum();
    }
}
