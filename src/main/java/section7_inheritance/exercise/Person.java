package section7_inheritance.exercise;

/**
 * Exercise31: Person
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public boolean isTeen() {
        return (age > 12 && age < 20);
    }

    public String getFullName() {
        return (firstName.isEmpty() ? "" : firstName) +
                ((!firstName.isEmpty() && !lastName.isEmpty()) ? " " : "") +
                (lastName.isEmpty() ? "" : lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = (age > 100 || age < 0) ? 0 : age;
    }
}
