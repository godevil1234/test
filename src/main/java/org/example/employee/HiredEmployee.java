package org.example.employee;

public class HiredEmployee extends Employee {
    private int fixedPayment = 50000;
    public HiredEmployee(String name) {
        super(name);
    }

    @Override
    public int calculatedSalary(){
        return fixedPayment;
    }
}
