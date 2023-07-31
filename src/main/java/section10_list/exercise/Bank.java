package section10_list.exercise;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public boolean addBranch(String name) {

        Branch branch = findBranch(name);
        if (branch != null) {
            return false;
        }
        branches.add(new Branch(name));

        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {

        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        for (Customer customer : branch.getCustomers()) {
            if (customer.getName().equals(customerName)) {
                return false;
            }
        }
        branch.newCustomer(customerName, transaction);

        return true;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {

        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        for (Customer customer : branch.getCustomers()) {
            if (customer.getName().equals(customerName)) {
                customer.addTransaction(transaction);
                return true;
            }
        }

        return false;
    }

    private Branch findBranch(String name) {

        for (Branch branch : branches) {
            if (branch.getName().equals(name)) {
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String name, boolean print) {

        Branch findBranch = findBranch(name);
        if (findBranch == null) {
            return false;
        }
        int i = 1;
        System.out.printf("Customer details for branch %s%n", findBranch.getName());
        for (Customer customer : findBranch.getCustomers()) {
            System.out.printf("Customer: %s[%d]%n", customer.getName(), i++);
            int j = 1;
            if (print) {
                System.out.println("Transactions");
                for (double transaction : customer.getTransactions()) {
                    System.out.printf("[%d]  Amount %.2f%n", j++, transaction);
                }
            }
        }

        return true;
    }

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
}
