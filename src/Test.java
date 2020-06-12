import java.util.Scanner;


public class Test {

	public enum EntityType {
		USER, GROUP, ROLE, APPLICATION, SCOPE, RESOURCE, PERMISSION, UNSPECIFIED,FINELINE_CATEGORY_MAPPING,CATEGORY_BUYER_MAPPING,
		BRC_BUYER_MAPPING,BUYER_BRC_MAPPING,ACTION
	}

	public static void main(String[] args) {
		System.out.println(EntityType.CATEGORY_BUYER_MAPPING.name());


	}

}
