import java.sql.SQLOutput;

/**
 * Connects one Customer to up to three MenuItem objects.
 * The items are stored in three separate fields (no arrays or collections).
 *
 * @author Christoff Allen B. Jumapit
 * @version 1.0
 */
public class Order {

    /** Maximum number of items allowed in one order. */
    private static final int MAX_ITEMS = 3;

    /** Discount rate for student customers (10%). */
    private static final double STUDENT_DISCOUNT_RATE = 0.10;

    /** The customer who placed the order. */
    private Customer customer;

    /** The first item of the order. */
    private MenuItem item1;

    /** The second item of the order. */
    private MenuItem item2;

    /** The third item of the order. */
    private MenuItem item3;

    /** The number of items currently in the order. */
    private int itemCount;

    /** The ID of the order. */
    private String orderId;

    /**
     * Creates an empty order for a customer.
     *
     * @param orderId  the ID of the order
     * @param customer the customer who placed the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
    }

    /**
     * Adds an item to the first empty slot of the order.
     * An order can hold at most three items.
     *
     * @param item the menu item to add
     * @return true if the item was added, false if the order is already full
     */
    public boolean addItem(MenuItem item) {
        // Reject the item when the order already has three items
        if (itemCount >= MAX_ITEMS) {
            System.out.println("Order is full. Cannot add " + item.getName()
                    + " [" + item.getItemCode() + "].");
            return false;
        } else {
            // Put the item in the first empty slot
            if (item1 == null) {
                item1 = item;
            } else if (item2 == null) {
                item2 = item;
            } else {
                item3 = item;
            }
            itemCount++;
            return true;
        }
    }

    /**
     * Computes the subtotal by adding the price of every item in the order.
     * Each call to computePrice() is polymorphic.
     *
     * @return the subtotal in pesos
     */
    public double computeSubtotal() {
        double subtotal = 0;
        // Add the price of each slot that has an item
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    /**
     * Computes the total. Student customers get a 10% discount.
     *
     * @return the total in pesos
     */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        // Students get 10% off, other customers pay the full subtotal
        if (customer.isStudent()) {
            return subtotal - (subtotal * STUDENT_DISCOUNT_RATE);
        } else {
            return subtotal;
        }
    }

    /**
     * Computes the total after the student discount (if any) and a voucher.
     * The total never goes below 0.
     *
     * @param voucher the voucher amount in pesos
     * @return the total in pesos
     */

    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;
        // The total can never be less than 0
        if (total < 0) {
            return 0;
        } else {
            return total;
        }
    }

    /**
     * Prints the receipt of this order without a voucher.
     * The customer's loyalty points are updated.
     */

    public void printReceipt() {
        printReceipt(0);
    }

    /**
     * Prints the receipt of this order with a voucher.
     * Shows each item, the subtotal, the discount, the voucher, the total,
     * and the customer's updated loyalty points.
     *
     * @param voucher the voucher amount in pesos (0 if there is no voucher)
     */
    public void printReceipt(double voucher) {

        // Add the student label to the header only for students
        if (customer.isStudent()) {
            System.out.println("Order #" + orderId + " - " + customer.getName() + " (Student)");
        } else {
            System.out.println("Order #" + orderId + " - " + customer.getName());
        }

        // Print each item that is in the order
        if (item1 != null) {
            printItemLine(item1);
        }
        if (item2 != null) {
            printItemLine(item2);
        }
        if (item3 != null) {
            printItemLine(item3);
        }



        double subtotal = computeSubtotal();
        System.out.println(String.format("  Subtotal: %.2f", subtotal));

        // Show the discount line only for students
        if (customer.isStudent()) {
            double discount = subtotal * STUDENT_DISCOUNT_RATE;
            System.out.println(String.format("  Student discount (10%%): -%.2f", discount));
        }

        // Show the voucher line only when a voucher is used
        if (voucher > 0) {
            System.out.println(String.format("  Voucher: -%.2f", voucher));
        }

        double total = computeTotal(voucher);
        System.out.println(String.format("  TOTAL: %.2f", total));

        // One loyalty point for every 50 pesos of the final total
        customer.addPoints(total);
        System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
    }

    /**
     * Prints one item line: description, dots, and price.
     *
     * @param item the menu item to print
     */
    private void printItemLine(MenuItem item) {
        String description = item.getDescription();
        String dots = "";
        // Fill the space between the description and the price with dots
        for (int i = description.length(); i < 38; i++) {
            dots += ".";
        }
        System.out.println(String.format("  %s %s %7.2f", description, dots, item.computePrice()));
    }

    /**
     * Gets the ID of this order.
     *
     * @return the order ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Gets the customer of this order.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the number of items in this order.
     *
     * @return the item count
     */
    public int getItemCount() {
        return itemCount;
    }
}
