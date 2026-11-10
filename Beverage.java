/**
 * Represents a drink sold at the campus cafe.
 * The price depends on the selected size (S, M, or L).
 *
 * @author Christoff Allen B. Jumapit
 * @version 1.0
 */
public class Beverage extends MenuItem {

    /** The size of the drink: "S", "M", or "L". */
    private String size;

    /**
     * Creates a beverage with default values.
     * The parent defaults are used and the size is "S".
     */
    public Beverage() {
        super();

        size = "S";
    }

    /**
     * Creates a beverage with the given values.
     *
     * @param name      the name of the drink
     * @param basePrice the base price in pesos
     * @param itemCode  the code of the drink
     * @param size      the size of the drink ("S", "M", or "L")
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        // Start with "S", then let the setter check the given size
        setSize("S");
        setSize(size);
    }

    /**
     * Computes the final price based on size.
     *
     * @return the price of this beverage in pesos
     */
    @Override
    public double computePrice() {
        // Large adds 25, Medium adds 15, Small uses the base price
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /**
     * Returns the description of this beverage, including its size.
     *
     * @return the description in the form "name [itemCode] Size: X"
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets the size of this beverage.
     *
     * @return the size ("S", "M", or "L")
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of this beverage.
     * Only "S", "M", or "L" is accepted. Any other value keeps the old size.
     *
     * @param size the new size
     */
    public final void setSize(String size) {
        // Accept only the three valid sizes
        if ("S".equals(size) || "M".equals(size) || "L".equals(size)) {
            this.size = size;
        } else {
            // Invalid size: keep the old value
            System.out.println("Error: size must be S, M, or L.");
        }
    }
}
