package eight;

import java.util.ArrayList;
import java.util.List;

public class Iterations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<String> items = new ArrayList<>();
		items.add("AB");
		items.add("B");
		items.add("C");
		items.add("DB");
		items.add("E");
		
		
		//lambda
		//Output : A,B,C,D,E
		items.forEach(item->System.out.println(item));
		
		//Output : C
		items.forEach(item->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});

		//method reference
		//Output : A,B,C,D,E
		items.forEach(System.out::println);

		//Stream and filter
		//Output : B
		items.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);
		

	}

}
