import java.util.ArrayList;
import java.util.List;

/**
 * Burger class for main burger ordering actions and options. It is incomplete until next week.
 */
public class Burger {
    // String & List (usually I'd just make these both String Arrays) of possible toppings and meats
    public final String[] POSSIBLETOPPINGS = new String[]{"pickles", "ketchup", "mustard", "onions"};
    public final List<String> MEATS = List.of(new String[]{"tuna", "turkey", "impossible", "black bean", "beef"});
    private String burgerMeat;
    private String temp;
    // TODO: check if want temp as rare, med-rare, or actual temp (90.1)
    public List<String> toppings = new ArrayList<>();
    // Toppings will not have a getter/setter because its already a data structure (a List)
    // So we'll use the list methods (no need to roll our own)

    // A getter just returns the value of the hidden (encapsulated as private) variable
    public String getBurgerMeat() {
        return burgerMeat;
    }

    /**
     * Getters & Setters don't usually have a comment (I usually just point them out).
     * But this does something important - it validates the data then either sets the variable
     * or sets it to the default beef based on a person's selection.
     *
     * @param burgerMeat The burger meat the person has selected from MEATS variable.
     */
    public void setBurgerMeat(String burgerMeat) {
        if (MEATS.contains(burgerMeat.toLowerCase())) {
            this.burgerMeat = burgerMeat;
        } else {
            this.burgerMeat = "beef";
        }
    }

    // Getter and setter for temp but see TODO: Numeric or String?
    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
