package section8_polymorphism.exercise;

public class Car {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public String startEngine() {
        return this.getClass().getSimpleName() + " engine is starting";
    }

    public String accelerate() {
        return this.getClass().getSimpleName() + " is accelerating";
    }

    public String brake() {
        return this.getClass().getSimpleName() + " is braking";
    }

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
