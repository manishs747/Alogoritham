package Interview.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {

       /*

       Expected:
        Total Space: 17752.5
        Transportation Cost: 832.84
        Service Charges: 68.75
        Total Cost: 901.59


        */

        /**
         * input
         *  25
         Package-1 Standard 3 16 10 5
         Package-2 Hazardous 2 14 18 7
         Package-3 Hazardous 2 25 15 10
         Package-4 Fragile 3 20 30 11
         */

        List<String[]> packages = new ArrayList<>();
        packages.add(new String[]{"Package-1", "Standard", "3", "16", "10", "5"});
        packages.add(new String[]{"Package-2", "Hazardous", "2", "14", "18", "7"});
        packages.add(new String[]{"Package-3", "Hazardous", "2", "25", "15", "10"});
        packages.add(new String[]{"Package-4", "Fragile", "3", "20", "30", "11"});

        System.out.println(cargoSpaceAndCost(25,packages));

    }


    public static Map<String, Double> cargoSpaceAndCost(int distance, List<String[]> packages) {
        Map<String, Double> results = new HashMap<>();

        // Placeholder, replace with calculated values

        // Time Complexity  - O(n)
        // Space Complexity - O(n)

        Double totalSpace = 0.0 , TransportCost = 0.0, ServiceCharge = 0.0, TotalCost = 0.0;
        for(String [] pkg : packages){
            String packageName = pkg[0];
            String type = pkg[1];
            Double Weight = Double.parseDouble(pkg[2]) ;
            Double length = Double.parseDouble(pkg[3]) ;
            Double width = Double.parseDouble(pkg[4]) ;
            Double height = Double.parseDouble(pkg[5]) ;
            List<Double> factorList = getFactor(type);
         /*   System.out.print(type);
            System.out.print(factorList);*/

            Double volume = length*width*height;

            TransportCost += volume * factorList.get(1);
            ServiceCharge += distance*factorList.get(2) + Weight*factorList.get(2);
            totalSpace += volume*factorList.get(0);
            TotalCost += (TransportCost + ServiceCharge);


        }

        results.put("Total Space", totalSpace);
        results.put("Transportation Cost", TransportCost);
        results.put("Service Charges", ServiceCharge);
        results.put("Total Cost", ServiceCharge+TransportCost);

        return results;
    }


    public static List<Double>  getFactor(String type){
        List<Double> list = new ArrayList<>();
        if(type.equalsIgnoreCase("Standard")){
            list.add(1.2);
            list.add(0.05);
            list.add(0.5);
            return list;
        }
        if(type.equalsIgnoreCase("Fragile")){
            list.add(1.5);
            list.add(0.07);
            list.add(0.75);
            return list;
        }
        if(type.equalsIgnoreCase("Hazardous")){
            list.add(1.25);
            list.add(0.06);
            list.add(0.625);
            return list;
        }
        return null;

    }


}
