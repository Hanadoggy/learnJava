package exercise.section11;

public class TestSave {

    public static void main(String[] args) {

        Monster monster = new Monster("Goblin", 10, 15);
        Player player = new Player("Yujin", 20, 30);

        System.out.println(player.write());
        System.out.println(monster.write());
        System.out.println(String.format("Hello world"));

    }

}
