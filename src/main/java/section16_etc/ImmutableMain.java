package section16_etc;

public class ImmutableMain {

    public static void main(String[] args) {

        Person oldJain = new Person("Jane", "01/01/1930");
        Person oldJim = new Person("Jim", "02/02/1932");
        Person oldJoe = new Person("Joe", "03/03/1934");
        Person[] oldJohnsKids = {oldJain, oldJim, oldJoe};
        Person oldJohn = new Person("John", "05/05/1900", oldJohnsKids);
        System.out.println(oldJohn);

        oldJohn.setKids(new Person[] {new Person("Ann", "04/04/1930")});
        System.out.println(oldJohn);

        Person[] oldKids = oldJohn.getKids();
        oldKids[0] = oldJim;
        System.out.println(oldJohn);

        oldKids = null;
        System.out.println(oldJohn);

        oldJohn.setKids(oldKids);
        System.out.println(oldJohn);

        System.out.println("------------------------");

        PersonRecord jane = new PersonRecord("Jane", "01/01/1930");
        PersonRecord jim = new PersonRecord("Jim", "02/02/1932");
        PersonRecord joe = new PersonRecord("Joe", "03/03/1934");
        PersonRecord[] johnsKids = {jane, jim, joe};
        PersonRecord john = new PersonRecord("John", "05/05/1900", johnsKids);
        System.out.println(john);

        PersonRecord[] kids = john.kids();
        kids[0] = jim;
        kids[1] = new PersonRecord("Ann", "04/04/1936");
        System.out.println(john);
    }

}
