package online;

public class WayFair {

    public static void main(String[] args) {

        /*

          Loyal customer:
          who visted both day and view unique product on both the day

          Alice
          charlie
          david
         */

        String[] day1Logs = {
                "2024-06-01T10:01:00Z Home alice",
                "2024-06-01T10:05:00Z Products alice",
                "2024-06-01T10:10:00Z Home bob",
                "2024-06-01T11:00:00Z Home charlie",
                "2024-06-01T11:30:00Z Contact charlie",
                "2024-06-01T12:00:00Z Products david"
        };

        String[] day2Logs = {
                "2024-06-02T10:01:00Z Products alice",
                "2024-06-02T10:05:00Z Cart alice",
                "2024-06-02T10:15:00Z Home bob",
                "2024-06-02T11:00:00Z About edward",
                "2024-06-02T11:30:00Z Contact charlie",
                "2024-06-02T12:00:00Z Cart david"
        };
    }
}
