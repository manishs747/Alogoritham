import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bank {

	public static void main(String[] args) {
       int [] arr = {1,1,1,3,3,2,2,2};
		System.out.println(majorityElement(arr));

	}

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		for (int n: nums) {
			map.put(n,map.getOrDefault(n,0)+1);
		}
		for (int key :map.keySet()) {
			if(map.get(key) > nums.length/3){
				list.add(key);
			}
		}
		return list;
	}

}
