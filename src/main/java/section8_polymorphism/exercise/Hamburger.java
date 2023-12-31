package section8_polymorphism.exercise;

public class Hamburger {

    private String name;
    private String meat;
    private double price;
    private String breadRollType;
    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
        System.out.printf("%s hamburger on a %s with %s, price is %s%n", name, breadRollType, meat, price);
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }

    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }

    public double itemizeHamburger() {
        return (price + addition1Price + addition2Price + addition3Price + addition4Price);
    }
}

