package basic.nested;

import java.util.Comparator;

public class StoreEmployee extends Employee {

    private String store;

    public StoreEmployee() {
    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-8s%s".formatted(store, super.toString());
    }

    /**
     * Nested class  -  instance of inner class
     * static nested class와는 다르게 생성할 때 클래스 명으로 접근하는 것이 아닌
     * 인스턴스를 통해서 생성해야함 -> new StoreEmployee.new StoreComparator<>();
     */
    public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {
        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            // 같은 store에서 일하면 yearStarted로 비교
            if (result == 0) {
                return new Employee.EmployeeComparator<>("yearStarted")
                        .compare(o1, o2);
            }
            return result;
        }
    }
}
