package exercise.Section8;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("Deluxe hamburger", "Deluxe meat", 19.10, "Deluxe bread");
        super.addHamburgerAddition1("fixings", 0);
        super.addHamburgerAddition2("chips", 0);
        super.addHamburgerAddition3("drink", 0);
        super.addHamburgerAddition4("", 0);
        System.out.println("Deluxe hamburger on a White roll with Sausage & Bacon, price is 19.10");
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("No more items can be added to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("No more items can be added to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("No more items can be added to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("No more items can be added to a deluxe burger");
    }
}
