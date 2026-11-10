/**
 * Represents the person placing an order at the campus cafe.
 * A customer can be a student and earns loyalty points for purchases.
 *
 * @author Christoff Allen B. Jumapit
 * @version 1.0
 */
public class Customer {

    /** Pesos that must be spent to earn one loyalty point. */
    private static final double PESOS_PER_POINT = 50;

    /** The name of the customer. */
    private String name;

    /** True if the customer is a student. */
    private boolean student;

    /** The loyalty points of the customer. It is never negative. */
    private int loyaltyPoints;

    /**
     * Creates a customer with default values.
     * The name is "Guest", the customer is not a student, and the points are 0.
     */

    public Customer() {
        this("Guest", false);
    }

    /**
     * Creates a customer who is not a student.
     *
     * @param name the name of the customer
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with a name and student status.
     *
     * @param name    the name of the customer
     * @param student true if the customer is a student
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points directly.
     * A negative number of points is rejected.
     *
     * @param points the number of points to add
     */
    public void addPoints(int points) {
        // Only add points that are not negative
        if (points >= 0) {
            loyaltyPoints += points;
        } else {
            // Reject the negative points so the total never goes below 0
            System.out.println("Error: points cannot be negative.");
        }
    }

    /**
     * Adds one loyalty point for every 50 pesos spent.
     * Any remainder below 50 pesos earns no point.
     *
     * @param amountSpent the amount spent in pesos
     */
    public void addPoints(double amountSpent) {
        // Whole points only: every full 50 pesos is one point
        int points = (int) (amountSpent / PESOS_PER_POINT);
        addPoints(points);
    }

    /**
     * Gets the name of the customer.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the customer is a student.
     *
     * @return true if the customer is a student, false otherwise
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets whether the customer is a student.
     *
     * @param student true if the customer is a student
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the loyalty points of the customer.
     *
     * @return the loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets the loyalty points of the customer.
     * A negative value is rejected and the old value is kept.
     *
     * @param loyaltyPoints the new loyalty points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        // Accept the value only when it is not negative
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            // Reject the negative value and keep the old one
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
