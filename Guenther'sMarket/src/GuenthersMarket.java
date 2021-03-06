import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuenthersMarket {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String continueToShop = "";
		boolean continueToShopValid = true;
		int shopperItemSelection;
		double totalCost = 0.00;
		
		ArrayList<String> shoppingCartItems = new ArrayList<>();
		ArrayList<Double> shoppingCartCost = new ArrayList<>();
		HashMap<String, String> menuItems = new HashMap<>();
		
		menuItems.put("apple", "      $0.99");
		menuItems.put("banana", "     $0.59");
		menuItems.put("ground beef", "$5.60");
		menuItems.put("pita bread", " $2.75");
		menuItems.put("pickles", "    $1.25");
		menuItems.put("onion", "      $0.89");
		menuItems.put("carrots", "    $0.93");
		menuItems.put("beets", "      $1.13");
		
		System.out.println("Welcome to Guenther's Market!");
		System.out.println("");
		
		do {
		continueToShopValid = true;
		printMenu();
		shopperItemSelection = orderSelection();
		
		if(shopperItemSelection == 1) {
			shoppingCartItems.add("apple");
			shoppingCartCost.add(0.99);
			System.out.println("Adding apple to cart at $0.99");
		} else if(shopperItemSelection == 2) {
			shoppingCartItems.add("banana");
			shoppingCartCost.add(0.59);
			System.out.println("Adding banana to cart at $0.59");
		} else if(shopperItemSelection == 3) {
			shoppingCartItems.add("ground beef");
			shoppingCartCost.add(5.60);
			System.out.println("Adding ground beef to cart at $5.60");
		} else if(shopperItemSelection == 4) {
			shoppingCartItems.add("pita bread");
			shoppingCartCost.add(2.75);
			System.out.println("Adding pita bread to cart at $2.75");
		} else if(shopperItemSelection == 5) {
			shoppingCartItems.add("pickles");
			shoppingCartCost.add(1.25);
			System.out.println("Adding pickles to cart at $1.25");
		} else if(shopperItemSelection == 6) {
			shoppingCartItems.add("onion");
			shoppingCartCost.add(0.89);
			System.out.println("Adding onion to cart at $0.89");
		} else if(shopperItemSelection == 7) {
			shoppingCartItems.add("carrots");
			shoppingCartCost.add(0.93);
			System.out.println("Adding carrots to cart at $0.93");
		} else if(shopperItemSelection == 8) {
			shoppingCartItems.add("beets");
			shoppingCartCost.add(1.13);	
			System.out.println("Adding beets to cart at $1.13");
		}
		
		
		System.out.println();
		
		while (continueToShopValid) {
		try {
			do {
		 
				System.out.print("Would you like to continue to shop? (y/n): ");
				continueToShop = scnr.next().toLowerCase();
			} while(!(continueToShop.equals("y") || continueToShop.equals("n")));
				
			continueToShopValid = false;
	
		} catch (InputMismatchException e) {
			System.out.println("That's not a valid choice. Please try again.");
			scnr.next();
		}	
		}
		
		} while (continueToShop.equals("y"));
		
		
		for (int i = 0; i < shoppingCartCost.size(); i++) {
			totalCost += shoppingCartCost.get(i);
		}
		
		System.out.println("You added the following items to your cart: ");
		
		for(int i = 0; i < shoppingCartItems.size(); i++) {
			System.out.print(shoppingCartItems.get(i) + " ");
			System.out.print("$" +shoppingCartCost.get(i));
			System.out.println();
		}
		
		//System.out.println(shoppingCartItems.toString());
		//System.out.println(shoppingCartCost.toString());
		highestCost(shoppingCartCost, shoppingCartItems);
		lowestCost(shoppingCartCost, shoppingCartItems);
		System.out.println("Your average cost per item is: $" + averageCost(shoppingCartCost));
		System.out.println("Your total cost is: $" + totalCost);
		System.out.println("Congratulations! There's no tax on this order because that's outside the scope of this build!");
		System.out.println("Thanks for shopping at Guenther's Market! Y'all come back now!");

	}
	
	public static void printMenu() {
		
		System.out.println("Item             Price");
		System.out.println("=======================");
		System.out.println("1. apple         $0.99");
		System.out.println("2. banana        $0.59");
		System.out.println("3. ground beef   $5.60");
		System.out.println("4. pita bread    $2.75");
		System.out.println("5. pickles       $1.25");
		System.out.println("6. onion         $0.89");
		System.out.println("7. carrots       $0.93");
		System.out.println("8. beets         $1.13");
	}
	
	public static int orderSelection() {
		
		int userSelection = 0;
		boolean continueLoop = true;
		
		Scanner scnr = new Scanner(System.in);
		
		while(continueLoop) {
			try {
				do {
					System.out.print("Please select an item to add to your cart (1-8): ");
		
					userSelection = scnr.nextInt();
		
					if(userSelection > 8 || userSelection < 1) {
						System.out.println("That's not a valid choice. Please try again.");
					}
				} while (userSelection > 8 || userSelection <1);
				continueLoop = false;
			} catch (InputMismatchException e) {
			System.out.println("That's not a valid choice. Please try again.");
			scnr.next();
		}
		}
		return userSelection;
	}
	
	public static double averageCost(ArrayList<Double> shoppingCartTotal) {
		
		double totalCost = 0.00;
		
		for (int i = 0; i < shoppingCartTotal.size(); i++) {
			totalCost += shoppingCartTotal.get(i);
		}
		
		double averageCost = totalCost / shoppingCartTotal.size();
		
		return averageCost;
	}
	
	public static void highestCost(ArrayList<Double> shoppingCartTotal, ArrayList<String> shoppingCartItem) {
		
		double highestPrice = 0.00;
		String itemName = "";
		
		for (int i = 0; i < shoppingCartTotal.size(); i++) {
			if(shoppingCartTotal.get(i) > highestPrice) {
				highestPrice = shoppingCartTotal.get(i);
				itemName = shoppingCartItem.get(i);
			}
		}
		
		System.out.println("Your highest priced item was " + itemName + ": $" + highestPrice);
		
	}
	
	public static void lowestCost(ArrayList<Double> shoppingCartTotal, ArrayList<String> shoppingCartItem) {
		
		double lowestPrice = 5.60;
		String itemName = "";
		
		for (int i = 0; i < shoppingCartTotal.size(); i++) {
			if(shoppingCartTotal.get(i) < lowestPrice) {
				lowestPrice = shoppingCartTotal.get(i);
				itemName = shoppingCartItem.get(i);
			}
		}
		
		System.out.println("Your lowest priced item was " + itemName + ": $" + lowestPrice);
		
	}
	
	
	

}
