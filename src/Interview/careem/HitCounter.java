package Interview.careem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/design-hit-counter/description/?envType=company&envId=careem&favoriteSlug=careem-all
 */
public class HitCounter {

    public static void main(String[] args) {
        /*
        Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).
Your system should accept a timestamp parameter (in seconds granularity), and you may assume that calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing). Several hits may arrive roughly at the same time.

Implement the HitCounter class:
HitCounter() Initializes the object of the hit counter system.
void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits may happen at the same timestamp.
int getHits(int timestamp) Returns the number of hits in the past 5 minutes from timestamp (i.e., the past 300 seconds).


Example 1:

Input
["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
[[], [1], [2], [3], [4], [300], [300], [301]]
Output
[null, null, null, null, 3, null, 4, 3]
         */

    }

    Queue<Integer> hitQueue = new LinkedList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        hitQueue.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!hitQueue.isEmpty() && hitQueue.peek() < timestamp-300){
            hitQueue.remove();
        }
        return hitQueue.size();
    }
}
