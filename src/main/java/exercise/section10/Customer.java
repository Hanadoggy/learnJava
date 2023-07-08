package exercise.section10;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        transactions.add(transaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
