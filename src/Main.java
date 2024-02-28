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
        if (choice > 0 && choice <=4) {
            return choice;
        }

        System.out.println("Please enter a choice between 1 & 4");
        return 4;
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
        return scan.nextLine().toLowerCase().startsWith("yes");
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
                if (meat.equalsIgnoreCase("turkey")) {
                    order += "a turkey burger with ";
                } else if (meat.equalsIgnoreCase("tuna")) {
                    order += "a tuna burger with ";
                } else {
                    order += "a beef burger with ";
                }

                System.out.println("We can make it plain or with tomatoes, onion, and pickles (default)");
                System.out.print("\tWhich option would you like?\n " +
                        "\t\t(we don't do substitutions so only 'plain' or 'all' as options): ");

                String toppings = scan.nextLine();
                order += toppings.equalsIgnoreCase("plain") ? "no toppings " : "all toppings ";

                totalPrice += 915;
            } else if (choice == 2) {
                System.out.println("We offer a 1. garden salad or 2. house salad (default)\n" +
                        "Its $3.25 no matter the size");
                System.out.print("Which would you like (1 or 2): ");

                if (Integer.parseInt(scan.nextLine()) == 1) {
                    order += "a garden salad ";
                } else {
                    order += "a house salad ";
                }

                order += getSize("small", "half", "full");
                totalPrice += 325;

            } else if (choice == 3) {
                System.out.println("We offer fountain drinks or water for $1.75");
                System.out.print("Would you like a fountain drink (y/n): ");
                if (scan.nextLine().toLowerCase().startsWith("y")) {
                    totalPrice += 175;
                    order += "a fountain drink ";
                }

                System.out.print("Would you like a water (y/n): ");
                if (scan.nextLine().toLowerCase().startsWith("y")) {
                    totalPrice += 175;
                    order += "a water ";
                }

            } else {
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