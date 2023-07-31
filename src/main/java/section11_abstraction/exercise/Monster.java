package section11_abstraction.exercise;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{

    private String name;
    private int hitPoints;
    private int strength;

    @Override
    public List<String> write() {

        List<String> output = new ArrayList<>();
        output.add(name);
        output.add(Integer.toString(hitPoints));
        output.add(Integer.toString(strength));

        return output;
    }

    @Override
    public void read(List<String> input) {

        if (input != null && input.size() > 0) {
            name = input.get(0);
            hitPoints = Integer.parseInt(input.get(1));
            strength = Integer.parseInt(input.get(2));
        }
    }

    @Override
    public String toString() {
        return String.format("Monster{name='%s', hitPoints=%d, strength=%d}",
                name, hitPoints, strength);
    }

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }
}
