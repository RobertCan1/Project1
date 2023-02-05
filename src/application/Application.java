package application;

import java.util.*;

import menu.Menu;
import order.Order;

public class Application {
    static Scanner sc = new Scanner(System.in);

	public static void information() {
		System.out.println("Welcome to my app!  Developed by RobertC");
	}
	public static void menus() {
		System.out.println("");
		System.out.println("Options");
		System.out.println("Press 1 to view files in ascending order");
		System.out.println("Press 2 to view option menu");
		System.out.println("Press 3 to Exit ");

		int choice = sc.nextInt();
		handlers(choice);
	}
	public static void handlers(int num) {
		switch(num) {
			case 1:
				Order.ascending();
				break;
			case 2:
				Menu.FileOperations();
				break;
			case 3:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Error: Input not found");
		}
		menus();
	}
	public static void main(String[] args) {
		information();
		menus();
	
	}
}


