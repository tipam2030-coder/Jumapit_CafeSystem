/**
 * Represents a baked item sold at the campus cafe.
 * A pastry can be warmed for an extra fee.
 *
 * @author Christoff Allen B. Jumapit
 * @version 1.0
 */

public class Pastry extends MenuItem {

    /** Extra fee in pesos for warming the pastry. */
    private static final double WARMING_FEE = 10;

    /** True if the pastry is warmed. */
    private boolean warmed;

    /**
     * Creates a pastry with default values.
     * The parent defaults are used and the pastry is not warmed.
     */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Creates a pastry with the given values.
     *
     * @param name      the name of the pastry
     * @param basePrice the base price in pesos
     * @param itemCode  the code of the pastry
     * @param warmed    true if the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        setWarmed(warmed);
    }

    /**
     * Computes the final price. A warmed pastry costs 10 pesos more.
     *
     * @return the price of this pastry in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add the warming fee only when the pastry is warmed
        if (warmed) {
            price += WARMING_FEE;
        }
        return price;
    }

    /**
     * Returns the description of this pastry. Shows "(Warmed)" when warmed.
     *
     * @return the description of the pastry
     */
    @Override
    public String getDescription() {
        String description = super.getDescription();
        // Show the warmed label only when the pastry is warmed
        if (warmed) {
            description += " (Warmed)";
        }
        return description;
    }

    /**
     * Checks if this pastry is warmed.
     *
     * @return true if warmed, false otherwise
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets whether this pastry is warmed.
     *
     * @param warmed true if the pastry is warmed
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
