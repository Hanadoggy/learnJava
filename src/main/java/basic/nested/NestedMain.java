package basic.nested;

import java.util.ArrayList;
import java.util.List;

public class NestedMain {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Yujin", 2021),
                new Employee(10022, "Sakura", 2014),
                new Employee(13151, "Kazuha", 2023),
                new Employee(10049, "Lei", 2019)
        ));

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

//        employees.sort(new Employee.EmployeeComparator<>("yearStarted"));
        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Opera_O", 2019, "Tiem"),
                new StoreEmployee(10029, "Bakusin_O", 2018, "Sakura"),
                new StoreEmployee(10032, "Urara", 2020, "Haru"),
                new StoreEmployee(10197, "Shuttle", 2023, "Taiki"),
                new StoreEmployee(10008, "Raurel", 2014, "Sakura")
        ));

//        var comparator = new Employee.EmployeeComparator<>();
//        storeEmployees.sort(comparator);

//        var genericEmployee = new StoreEmployee();
//        var comparator = genericEmployee.new StoreComparator<>();

        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);

        for (StoreEmployee s : storeEmployees) {
            System.out.println(s);
        }

        System.out.println("With Pig Latin Names");
        addPingLatinName(storeEmployees);

    }

    public static void addPingLatinName(List<? extends StoreEmployee> list) {

        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {

            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        // list의 sort method에 null을 전달하면 Comparable's compare을 사용하여 정렬함
        newList.sort(null);
        for (var dEmployee : newList) {
            System.out.println(dEmployee.originalInstance.getName() + " "
            + dEmployee.pigLatinName);
        }
    }
}
