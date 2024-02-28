import java.util.Scanner;
/* Created 2/15/2024 by Sam Greenwell for students to use in class
   MIT Licensed (see license.md in root repository)
 */
public class Main {
    // Scanner variable to be shared by all functions
    static Scanner scan = new Scanner(System.in);

    /** This is a javadoc - it is used to describe functions
     *  Takes no parameters and prints the main menu then gets the user's selection
     *  .
     * @return choice : The choice made by user (number 1-4)
     */
    static int getChoice() {
        System.out.println("Please select from the following choices: ");
        System.out.println("\t1. Order Burger\t2.Order Salad\n\t3. Order Drink\t4. Display Total");

        System.out.print("Which option will you use?");
        int choice = Integer.parseInt(scan.nextLine());

        // TODO: Add an if here that checks if choice is between 1 & 4 and returns it
        //       IF NOT then return 4 by default

        return choice;
    }

    /**
     * Function used by order items to determine what size the person wants.
     * All items have 3 sizes so this displays them & checks a correct selection is made.
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

        // TODO: check if they say yes or no and return true or false based on that
        //       Currently this always exits after the first loop.
        return false;
    }

    public static void main(String[] args) {
        // Set the default values for all functions
        // Have to have choice as 0 because we need to re-get it in while
        int totalPrice = 0;
        String order = "You've ordered ";
        boolean keepOrdering = true;
        int choice = 0;

        // Main Loop - keep running the code until they say stop (using boolean flag)
        while (keepOrdering) {
            // At start of while loop we get the choice and see what they want
            choice = getChoice();

            if (choice == 1) {
                // Burger Order - burgers don't have sizes
                /* Burger cost from https://ag.purdue.edu/cfdas/data-resources/the-cost-of-a-burger/
                   Showing a 3.02 cost in IL (so *3 = 9.18 so we'll say $9.15)
                 */
                System.out.println("Our burgers are $9.15");
                System.out.println("We provide turkey, tuna, or beef burgers (beef is default)");
                System.out.print("Which meat would you like: ");

                String meat = scan.nextLine();

                // TODO: Check if they select turkey or tuna - if so add that to order
                //       IF NOT then add a beef burger as the default.
                order += "a beef burger with ";

                System.out.println("We can make it plain or with tomatoes, onion, and pickles (default)");
                System.out.print("\tWhich option would you like?\n " +
                        "\t\t(we don't do substitutions so only 'plain' or 'all' as options): ");

                // This is pretty simple so I'll leave it - ternary operator can be if/else
                String toppings = scan.nextLine();
                order += toppings.equalsIgnoreCase("plain") ? "no toppings " : "all toppings ";

                totalPrice += 915;
            } else if (choice == 2) {
                System.out.println("We offer a 1. garden salad or 2. house salad (default)\n" +
                        "Its $3.25 no matter the size");
                System.out.print("Which would you like (1 or 2): ");

                // TODO: Add if/else for ordering a garden or house salad (either ternary or if/else)
                order += "a house salad ";

                order += getSize("small", "half", "full");
                totalPrice += 325;

            } else if (choice == 3) {
                System.out.println("We offer fountain drinks or water for $1.75");

                // TODO: We are now adding both no matter what but we should check...
                //       Add the if statements needed to check if we are adding these drinks
                //       Don't forget their a buck 75 each!
                System.out.print("Would you like a fountain drink (y/n): ");
                totalPrice += 175;
                order += "a fountain drink ";

                System.out.print("Would you like a water (y/n): ");
                totalPrice += 175;
                order += "a water ";

            } else {
                // This just prints the current order (so if over 4 we don't care)
                System.out.printf("%s\n\tAt $%.2f\n",
                        order, totalPrice/100.0);
            }

            // Call checkExit to see if we keep asking for order items.
            keepOrdering = checkExit();
        }

        // print a bunch of newlines then the order & price
        System.out.printf("\n\n\n\n\n\n%s\n\tAt $%.2f\n",
                order, totalPrice/100.0);
    }
}