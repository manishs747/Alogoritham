package company.flipkart.makemefat;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Menu menu = MenuFactory.createMenu();

		while (true) {
			printMenu();
			Scanner in = new Scanner(System.in);
			String input = in.next();
			System.out.println("Your Input: " + input);

			if (input.equals("a")) {
				System.out.println("ENTER ID, Name, Price, Calorie");
				String createMenuInput = in.next();
				System.out.println("Your Input: " + createMenuInput);
				String[] values = createMenuInput.split(",");
				if (values.length < 4) {
					System.out.println("Invalid input for create menu");
					continue;
				}
				try {
					menu.createMenu(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]),
							Integer.parseInt(values[3]));
					System.out.println("Success");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			} else if (input.equals("b")) {
				System.out.println("ENTER ID,New Price");
				String updateMenuInput = in.next();
				System.out.println("Your Input: " + updateMenuInput);
				String[] values = updateMenuInput.split(",");
				if (values.length < 2) {
					System.out.println("Invalid input for update price");
					continue;
				}
				try {
					menu.updatePrice(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (input.equals("c")) {
				System.out.println("How much money Does customer have");
				int price = in.nextInt();
				System.out.println("Your Input: " + price);
				try {
					menu.serveCustomer(price);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (input.equals("d")) {
				menu.printMenu();
			} else {
				System.out.println("Invalid Input");
			}
		}

	}

	public static void printMenu() {
		System.out.println();
		System.out.println("What would you like to do");
		System.out.println("    a) Create menu item");
		System.out.println("    b) Update Price of menu");
		System.out.println("    c) Serve Customer");
		System.out.println("    d) Print Menu");
	}

}
