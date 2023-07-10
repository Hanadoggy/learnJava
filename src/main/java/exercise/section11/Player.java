package exercise.section11;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    @Override
    public List<String> write() {

        List<String> output = new ArrayList<>();
        output.add(name);
        output.add(Integer.toString(hitPoints));
        output.add(Integer.toString(strength));
        output.add(weapon);

        return output;
    }

    @Override
    public void read(List<String> input) {

        if (input != null && input.size() > 0) {
            name = input.get(0);
            hitPoints = Integer.parseInt(input.get(1));
            strength = Integer.parseInt(input.get(2));
            weapon = input.get(3);
        }
    }

    @Override
    public String toString() {
        return String.format("Player{name='%s', hitPoints=%d, strength=%d, weapon='%s'}",
                name, hitPoints, strength, weapon);
    }

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
