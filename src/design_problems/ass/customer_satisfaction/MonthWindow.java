package design_problems.ass.customer_satisfaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MonthWindow implements lWindow{
    private static final DateTimeFormatter MONTH_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM");
     public String getWindowKey(LocalDate localDate){
       return localDate.format(MONTH_FORMAT);
     }
}
