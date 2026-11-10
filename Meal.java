/**
 * Represents a rice meal sold at the campus cafe.
 * A meal can be upsized and can have extra sides.
 *
 * @author Christoff Allen B. Jumapit
 * @version 1.0
 */
public class Meal extends MenuItem {

    /** Extra fee in pesos for an upsized meal. */
    private static final double UPSIZE_FEE = 20;

    /** Price in pesos of one extra side. */
    private static final double SIDE_PRICE = 12;

    /** True if the meal is upsized. */
    private boolean upsized;

    /** Number of extra sides added to the meal. */
    private int extraSides;

    /**
     * Creates a meal with default values.
     * The parent defaults are used, the meal is not upsized, and it has 0 extra sides.
     */
    public Meal() {
        super();
       upsized = false;
       extraSides = 0;
    }

    /**
     * Creates a meal with the given values.
     *
     * @param name       the name of the meal
     * @param basePrice  the base price in pesos
     * @param itemCode   the code of the meal
     * @param upsized    true if the meal is upsized
     * @param extraSides the number of extra sides (negative values are rejected)
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);

        setUpsized(upsized);
        // Use the setter so a negative number of sides is rejected
        setExtraSides(0);
        setExtraSides(extraSides);
    }

    /**
     * Computes the final price: base price, plus 20 if upsized, plus 12 for each extra side.
     *
     * @return the price of this meal in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add the upsize fee only when the meal is upsized
        if (upsized) {
            price += UPSIZE_FEE;
        }
        price += SIDE_PRICE * extraSides;
        return price;
    }

    /**
     * Returns the description of this meal, including the upsize status
     * and the number of extra sides.
     *
     * @return the description of the meal
     */
    @Override
    public String getDescription() {
        String sizeText;
        String sidesText;
        // Choose the upsize label
        if (upsized) {
            sizeText = "Upsized";
        } else {
            sizeText = "Regular";
        }
        // Use "side" for exactly one side, "sides" for any other number
        if (extraSides == 1) {
            sidesText = extraSides + " side";
        } else {
            sidesText = extraSides + " sides";
        }
        return super.getDescription() + " " + sizeText + ", " + sidesText;
    }

    /**
     * Checks if this meal is upsized.
     *
     * @return true if upsized, false otherwise
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets whether this meal is upsized.
     *
     * @param upsized true if the meal is upsized
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets the number of extra sides.
     *
     * @return the number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides.
     * A negative value is rejected and the old value is kept.
     *
     * @param extraSides the new number of extra sides
     */
    public final void setExtraSides(int extraSides) {
        // Accept the value only when it is not negative
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            // Reject the negative value and keep the old one
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}
