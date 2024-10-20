package org.example.employee;

public class Contractor extends Employee {
    private final int paymentForHour = 200;
    public Contractor(String name) {
        super(name);
    }

    @Override
    public int calculatedSalary(){
        return paymentForHour * getTimeSpent();
    }
}
