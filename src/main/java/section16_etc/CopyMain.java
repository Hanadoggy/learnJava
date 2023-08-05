package section16_etc;

import java.util.Arrays;
import java.util.List;

record Person2 (String name, String dob, Person2[] kids) {

    public Person2(Person2 p) {
        this(p.name, p.dob,
                p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }

    public Person2(String name, String dob) {
        this(name, dob, null);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}


public class CopyMain {

    public static void main(String[] args) {

        Person2 joe = new Person2("Joe", "01/01/1961");
        Person2 jim = new Person2("Jim", "02/02/1962");
        Person2 jack = new Person2("Jack", "03/03/1963",
                new Person2[]{joe, jim});
        Person2 jane = new Person2("Jane", "04/04/1964");
        Person2 jill = new Person2("Jill", "05/05/1865",
                new Person2[]{joe, jim});

        Person2[] persons = {joe, jim, jack, jane, jill};
//        Person2[] personsCopy = Arrays.copyOf(persons, persons.length);
        Person2[] personsCopy = new Person2[5];

        for (int i = 0; i < 5; i++) {
            Person2 current = persons[i];
            var kids = current.kids() == null ? null :
                    Arrays.copyOf(current.kids(), current.kids().length);
            // 내부 원소가 참조하는 객체까지 완전히 깊은 복사를 떠야함

            personsCopy[i] = new Person2(current.name(), current.dob(), kids);
        }
        // 원소 하나하나를 직접 복사, deep copy
//        Arrays.setAll(personsCopy, i -> new Person2(persons[i]));

        var jillsKids = personsCopy[4].kids();
        jillsKids[1] = jane;

        for (int i = 0; i < 5; i++) {
            if (persons[i] == personsCopy[i]) {
                System.out.println("Equal References " + persons[i]);
            }
        }

        System.out.println(persons[4]);
        System.out.println(personsCopy[4]);
        // 하지만 깊은 복사한 kids의 내부 객체는 원본 객체를 참조중, 더 깊은 복사가 필요
    }

}
