package exercise.section8;

public class HealthyBurger extends Hamburger {

    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;


    public HealthyBurger(String meat, double price) {
        super("Healthy hamburger", meat, price, "Healthy bread");
        System.out.printf("Healthy hamburger on a Brown rye roll with %s, price is %f%n", meat, price);
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }

    @Override
    public double itemizeHamburger() {
        return (super.itemizeHamburger() + healthyExtra1Price + healthyExtra2Price);
    }
}
