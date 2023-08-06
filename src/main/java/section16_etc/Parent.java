package section16_etc;

public class Parent {

    static {
        System.out.println("Parent static initializer : class being constructed");
    }
    private final String name;
    private final String dob;
    protected final int siblings;

    {
//        name="AhnYujin";
//        dob="01/09/2003";
        System.out.println("In Parent Initializer");
    }
    // instance initializer block


    public Parent(String name, String dob, int siblings) {
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        // 생성자의 코드가 실행되기 전에 인스턴스 설정기가 동작
        System.out.println("In Parent Constructor");
    }

//    public Parent() {
//        System.out.println("In Parent's No Args Constructor");
//    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", dob='" + dob + '\'';
    }
}
