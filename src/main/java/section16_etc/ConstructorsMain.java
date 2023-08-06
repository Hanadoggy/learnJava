package section16_etc;

public class ConstructorsMain {

    public static void main(String[] args) {

        Parent parent = new Parent("yujin", "01/09/2003", 4);
        Child child = new Child();

        System.out.println("parent = " + parent);
        System.out.println("child = " + child);

        RecordPerson person = new RecordPerson("yujin", "01-09-2003");
        System.out.println(person);

        Person yujin = new Person("yujin", "01/09/2003");
        System.out.println(yujin);

        Generation g = Generation.BABY_BOOMER;
//        Generation h = new Generation.BABY_BOOMER(1990, 2000);
    }

}
