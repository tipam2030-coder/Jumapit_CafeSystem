/**
 * Main class of the campus cafe ordering system.
 * It creates customers, menu items, and orders, then prints two receipts.
 *
 * @author Christoff Allen B. Jumapit and Lenny Devibar
 * @version 1.0
 */
public class CafeApp {

    /**
     * Starts the program.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Two customers made with different constructors
        Customer christoff = new Customer("Christoff Allen B. Jumapit", true);
        Customer jelres = new Customer("Jelres Romano");


        // ----- Order #1001 (parameterized constructors) -----
        Beverage milkTea = new Beverage("Milk Tea", 36.0, "B-01", "L");
        Pastry donuts = new Pastry("Donuts", 20.0, "P-01", true);
        Meal chickenInasal = new Meal("Chicken inasal", 210.0, "M-01", true, 1);

        // Cookie uses the default Pastry constructor, then setters
        Pastry crinkles = new Pastry();
        crinkles.setName("Crinkles");
        crinkles.setBasePrice(30.0);
        crinkles.setItemCode("P-02");

        Order order1 = new Order("1001", christoff);
        order1.addItem(milkTea);
        order1.addItem(donuts);
        order1.addItem(chickenInasal);

        // Fourth item: the order is full, so it is rejected

        order1.printReceipt();

        order1.addItem(crinkles);



        System.out.println();

        // ----- Order #1002 (default constructors and setters) -----
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        // Invalid data: the setter rejects the negative price
        hotChocolate.setBasePrice(100);
        hotChocolate.setBasePrice(-80);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setBasePrice(130.0);
        beefTapa.setItemCode("M-02");

        Order order2 = new Order("1002", jelres);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        // Print the receipt with a 20 peso voucher
        order2.printReceipt(20);


    }




}
