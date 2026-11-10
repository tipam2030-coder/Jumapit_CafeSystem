/**
 * Abstract parent class of every item sold at the campus cafe.
 * It cannot be instantiated directly. Each subclass defines its own pricing.
 *
 * @author Christoff Allen B. Jumapit
 * @version 1.0
 */
public abstract class MenuItem {

    /** The name of the menu item. */
    protected String name;

    /** The base price of the menu item in pesos. */
    protected double basePrice;

    /** The code that identifies the menu item (for example, B-01). */
    private String itemCode;

    /**
     * Creates a menu item with default values.
     * Name is "Unnamed Item", base price is 0.0, and item code is "N/A".
     */
    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    /**
     * Creates a menu item with the given values.
     *
     * @param name      the name of the item
     * @param basePrice the base price in pesos (negative values are rejected)
     * @param itemCode  the code of the item
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        setName(name);
        setItemCode(itemCode);

        // Use the setter so a negative price is rejected (price stays 0.0)
        this.basePrice = 0.0;
        setBasePrice(basePrice);
    }

    /**
     * Computes the final price of this item.
     * Each subclass defines its own pricing.
     *
     * @return the final price in pesos
     */
    public abstract double computePrice();

    /**
     * Returns the name and item code of this item.
     * Subclasses override this method to add more details.
     *
     * @return the description in the form "name [itemCode]"
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the name of this item.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this item.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the base price of this item.
     *
     * @return the base price in pesos
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price of this item.
     * A negative value is rejected and the old price is kept.
     *
     * @param basePrice the new base price in pesos
     */
    public final void setBasePrice(double basePrice) {
        // Accept the price only when it is not negative
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            // Reject the negative price and keep the old value
            System.out.println("Error: base price cannot be negative.");
        }
    }

    /**
     * Gets the item code of this item.
     *
     * @return the item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code of this item.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
