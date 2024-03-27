import java.util.ArrayList;
import java.util.List;

/**
 * Burger class for main burger ordering actions and options. It is incomplete until next week.
 */
public class Burger {
    // String & List (usually I'd just make these both String Arrays) of possible toppings and meats
    public final String[] POSSIBLETOPPINGS = new String[]{"pickles", "ketchup", "mustard", "onions"};
    public final List<String> MEATS = List.of(new String[]{"tuna", "turkey", "impossible", "black bean", "beef"});
    public String burgerMeat;
    public String temp;
    // TODO: check if want temp as rare, med-rare, or actual temp (90.1)
    public List<String> toppings = new ArrayList<>();

}
