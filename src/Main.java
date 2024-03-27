import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* Created 2/15/2024 by Sam Greenwell for students to use in class
   MIT Licensed (see license.md in root repository)
   This is neither efficient code nor secure code - use at own risk in production level.
   It is meant for learning to program.
 */
public class Main {
    // Scanner variable to be shared by all functions
    static Scanner scan = new Scanner(System.in);

    /** This is a javadoc - it is used to describe functions
     *  Takes no parameters and prints the main menu then gets the user's selection
     *
     * @return choice : The choice made by user (number 1-4)
     */
    static int getChoice() {
        System.out.println("Please select from the following choices: ");
        System.out.println("\t1. Order Burger\t2.Order Salad\n\t3. Order Drink\t4. Display Total");

        System.out.print("Which option will you use?");
        int choice = Integer.parseInt(scan.nextLine());
        if (choice > 0 && choice <=4) {
            return choice;
        }

        System.out.println("Please enter a choice between 1 & 4");
        return 4;
    }

    /**
     * Function used by order items to determine what size the person wants.
     * All items have 3 sizes so this displays them & checks a correct selection is made.
     *
     * @return The size selection based on passed options
     */
    static String getSize(String smallest, String medium, String largest) {
        System.out.printf("Please select a %s, %s, %s sized item (2nd size is default): ",
                smallest, medium, largest);
        String size = scan.nextLine();
        if (size.equalsIgnoreCase(smallest)) {
            return smallest + " size ";
        } else if (size.equalsIgnoreCase(largest)) {
            return largest + " size ";
        } else {
            return medium + " size ";
        }
    }

    /**
     * Function checks if person wants to continue ordering
     * @return True if person says they want to continue and false if not
     */
    static boolean checkExit() {
        System.out.print("Do you want to continue ordering? (yes/no)");
        return scan.nextLine().toLowerCase().startsWith("yes");
    }

    public static void main(String[] args) {
        // Set the default values for all functions
        // Have to have choice as 0 because we need to re-get it in while
        int totalPrice = 0;

        boolean keepOrdering = true;
        List<String> order = new ArrayList<>();

        Burger burger = new Burger();
        int choice = 0;

        // Main Loop - keep running the code until they say stop (using boolean flag)
        while (keepOrdering) {
            // At start of while loop we get the choice and see what they want
            choice = getChoice();

            switch (choice) {
                case 1:

                    // Burger Order - burgers don't have sizes
                    /* Burger cost from https://ag.purdue.edu/cfdas/data-resources/the-cost-of-a-burger/
                       Showing a 3.02 cost in IL (so *3 = 9.18 we'll say $9.15)
                     */
                    System.out.println("Our burgers are $9.15 + toppings");
                    System.out.println("We provide the following meats (beef is default)");

                    for (var meat : burger.MEATS) {
                        System.out.printf("\t%s\n", meat);
                    }

                    System.out.print("Which meat would you like: ");

                    String meat = scan.nextLine();
                    if (burger.MEATS.contains(meat.toLowerCase())) {
                        burger.burgerMeat = meat;
                    } else {
                        burger.burgerMeat = "beef";
                    }


                    while (true) {
                        System.out.println("We can make it plain or with everything. Otherwise topping choices include");
                        for (var topping : burger.POSSIBLETOPPINGS) {
                            System.out.printf("\t%s\n", topping);
                        }
                        System.out.print("\tWhich option (plain, all, or a topping) would you like? ");

                        String topping = scan.nextLine();

                        // See this next line just checks if it says plain (so "I like plain" would work)
                        if (topping.toLowerCase().contains("plain")) {
                            order.add(String.format("%s burger plain", burger.burgerMeat));
                            break;
                        } else if (topping.equalsIgnoreCase("all")) {
                            order.add(String.format("%s burger with all toppings", burger.burgerMeat));
                            break;
                        } else {
                            burger.toppings.add(topping);

                            System.out.println("Do you want to exit? (yes/no)");
                            if (scan.nextLine().equalsIgnoreCase("yes")) {
                                order.add(String.format("%s burger with %s",
                                        burger.burgerMeat, burger.toppings));
                                break;
                            }
                        }
                    }
                    totalPrice += 915;
                    break;

                // For simplicity - I've removed cases 2 & 3 for now
                case 2:
                    System.out.println("adding a simple salad ($2) under construction");
                    order.add("simple salad");
                    totalPrice += 200;
                    break;
                case 3:
                    System.out.println("Adding a medium fountain drink ($1) - under construction");
                    order.add("medium fountain drink");
                    totalPrice += 100;
                    break;
                default:
                    System.out.printf("%s\n\tAt $%.2f\n",
                            order, totalPrice/100.0);
            }

            keepOrdering = checkExit();
        }

        // print a bunch of newlines then the order & price
        System.out.printf("\n\n\n\n\n\n%s\n\tAt $%.2f\n",
                order, totalPrice/100.0);
    }
}