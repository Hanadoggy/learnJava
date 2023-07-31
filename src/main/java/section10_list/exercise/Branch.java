package section10_list.exercise;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public boolean newCustomer(String name, double transaction) {

        Customer customer = findCustomer(name);
        if (customer != null) {
            return false;
        }
        customers.add(new Customer(name, transaction));

        return true;
    }

    public boolean addCustomerTransaction(String name, double transaction) {

        Customer customer = findCustomer(name);
        if (customer == null) {
            return false;
        }
        customer.addTransaction(transaction);

        return true;
    }

    private Customer findCustomer(String name) {

        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }

        return null;
    }

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
