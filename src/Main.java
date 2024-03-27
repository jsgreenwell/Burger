import java.util.Scanner;
/* Created 2/15/2024 by Sam Greenwell for students to use in class
   MIT Licensed (see license.md in root repository)
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

        String order = "You've ordered ";
        boolean keepOrdering = true;
        // TODO: Last - change order to a List of Strings and append instead of concat

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
                    System.out.println("Our burgers are $9.15 for beef");

                    // TODO: 1st - change this to print out the Meat options from Class (no index)
                    System.out.println("We provide turkey, tuna, or beef burgers (beef is default)");

                    System.out.print("Which meat would you like: ");

                    String meat = scan.nextLine();

                    //TODO: 2nd change this to check if meat type is valid using List methods
                    if (meat.equalsIgnoreCase("turkey")) {
                        order += "a turkey burger with ";
                    } else if (meat.equalsIgnoreCase("tuna")) {
                        order += "a tuna burger with ";
                    } else {
                        order += "a beef burger with ";
                    }


                    while (true) {
                        //TODO: 3rda: Repeat what we did with List method (need to change it to a List)
                        //TODO: 3rdb: Check first if they say "plain" in their response (using String methods & chaining)
                        System.out.println("We can make it plain or with tomatoes, onion, and pickles (default)");
                        System.out.print("\tWhich option (plain, all, or a topping) would you like?\n ");

                        String toppings = scan.nextLine();
                        // See this next line is not great because "I want plain" would move to default
                        if (toppings.equalsIgnoreCase("plain")) {
                            order += "set to no toppings ";
                            break;
                        } else if (toppings.equalsIgnoreCase("all")) {
                            order += "set to all toppings";
                            break;
                        } else {
                            // See and this should validate the topping first
                            // ALSO it should check if we've selected all the toppings
                            order += toppings;

                            System.out.println("Do you want to exit? (yes/no)");
                            if (scan.nextLine().equalsIgnoreCase("yes")) {
                                break;
                            }
                        }
                    }
                    totalPrice += 915;
                    break;

                // For simplicity - I've removed cases 2 & 3 for now
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