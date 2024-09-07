package dynamic_programming;

import java.util.*;


public class Test {


    public static void main(String[] args) {


        List<String> str = Arrays.asList("{\"deployment_id\":\"d-1\", \"status\":\"Success\"}","{\"deployment_id\":\"d-2\", \"status\":\"Fail\"}","{\"deployment_id\":\"d-1\", \"status\":\"abc\"}");
        System.out.println(fun(str));
    }

    public static List<Integer> fun(List<String> deployments){
        int suc = 0 , fail = 0 , error = 0;

        for (String json:deployments) {
            Map<String, String> jsonMap = parseJson(json);
            String deployment_id = jsonMap.get("deployment_id");
            //12 char and start with d- and it should alpha numer small case
            if(!deployment_id.matches("d-[a-z0-9]{9}")){
                error++;
                continue;
            }

            String status = jsonMap.get("status");
            if(status.startsWith("Success")){
                status = "Success";
            }
            if("Success".equals(status)){
                suc++;
            } else if("Fail".equals(status)){
                fail++;
            }else {
                error++;
            }
        }

        return Arrays.asList(suc,fail,error);
    }


    public static boolean isValidString(String input) {
        // Check if the string is exactly 12 characters long
        if (input.length() != 12) {
            return false;
        }

        // Check if the string starts with "d-"
        if (!input.startsWith("d-")) {
            return false;
        }

        // Check if the rest of the string is alphanumeric and lowercase
        for (int i = 2; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isLowerCase(c) && !Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static Map<String, String> parseJson(String json) {
        Map<String, String> map = new HashMap<>();
        json = json.trim().substring(1, json.length() - 1); // Remove the curly braces
        String[] pairs = json.split(","); // Split the string into key-value pairs

        for (String pair : pairs) {
            String[] keyValue = pair.split(":"); // Split each pair into key and value
            String key = keyValue[0].trim().replaceAll("^\"|\"$", ""); // Remove leading and trailing quotes
            String value = keyValue[1].trim().replaceAll("^\"|\"$", ""); // Remove leading and trailing quotes
            map.put(key, value);
        }
        return map;
    }












    public static List<String> get(String str){
        List<String> result = new ArrayList<>();
        String [] splitStr  =  str.split("\\|");
        Map<String,String> map = new TreeMap<>();
        for (String sptWord:splitStr) {
           if(map.containsKey(sptWord.substring(0,4)) || sptWord.isEmpty()) {
                return Arrays.asList("abc");
            }
            map.put(sptWord.substring(0,4),sptWord.substring(4));
        }
        int counter = 1;
        for (String key:map.keySet()) {
            int number = Integer.parseInt(key);
            if(counter++ != number)  return Arrays.asList("INVALID");
            System.out.println(number );
           result.add(map.get(key)) ;
        }
        return result;

    }






}
