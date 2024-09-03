import java.util.Scanner;

public class PizzaBillGenerator {
    
    // Constants for prices
    private static final int VEG_PIZZA = 300;
    private static final int NON_VEG_PIZZA = 400;
    private static final int DELUX_VEG_PIZZA = 550;
    private static final int DELUX_NON_VEG_PIZZA = 650;
    private static final int EXTRA_CHEESE = 100;
    private static final int EXTRA_TOPPINGS = 150;
    private static final int TAKE_AWAY = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Display the welcome message
        System.out.println("------------------------------------Welcome to Pizzamania--------------------------------------------------------");
        
        // Select pizza type
        System.out.println("Which pizza: (1. Veg Pizza 2. Non-Veg Pizza 3. Delux Veg Pizza 4. Delux Non-veg Pizza)");
        int pizzaType = scanner.nextInt();
        
        int pizzaPrice = 0;
        boolean isDelux = false;
        
        switch (pizzaType) {
            case 1:
                pizzaPrice = VEG_PIZZA;
                break;
            case 2:
                pizzaPrice = NON_VEG_PIZZA;
                break;
            case 3:
                pizzaPrice = DELUX_VEG_PIZZA;
                isDelux = true;
                break;
            case 4:
                pizzaPrice = DELUX_NON_VEG_PIZZA;
                isDelux = true;
                break;
            default:
                System.out.println("Invalid selection! Exiting...");
                return;
        }
        
        // Check for extra toppings (not for Delux pizzas)
        int extraToppingsPrice = 0;
        if (!isDelux) {
            System.out.println("Want Extra Topping (y/n)?");
            char extraToppings = scanner.next().charAt(0);
            if (extraToppings == 'y' || extraToppings == 'Y') {
                extraToppingsPrice = EXTRA_TOPPINGS;
            }
        }
        
        // Check for extra cheese
        int extraCheesePrice = 0;
        System.out.println("Extra Cheese (y/n)?");
        char extraCheese = scanner.next().charAt(0);
        if (extraCheese == 'y' || extraCheese == 'Y') {
            extraCheesePrice = EXTRA_CHEESE;
        }
        
        // Check for takeaway
        int takeAwayPrice = 0;
        System.out.println("Want TakeAway (y/n)?");
        char takeAway = scanner.next().charAt(0);
        if (takeAway == 'y' || takeAway == 'Y') {
            takeAwayPrice = TAKE_AWAY;
        }
        
        // Calculate total amount
        int totalAmount = pizzaPrice + extraToppingsPrice + extraCheesePrice + takeAwayPrice;
        
        // Print the bill
        System.out.println("\n---- Bill ----");
        System.out.println("Pizza: " + pizzaPrice);
        if (extraCheesePrice > 0) {
            System.out.println("Extra Cheese: " + extraCheesePrice);
        }
        if (extraToppingsPrice > 0) {
            System.out.println("Extra Toppings: " + extraToppingsPrice);
        }
        if (takeAwayPrice > 0) {
            System.out.println("Take away: " + takeAwayPrice);
        }
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("\nThank you!!!! Visit Again");
        System.out.println("---------------------------------------------------------------------------------------------------");
        
        scanner.close();
    }
}
