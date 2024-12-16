package org.example.employee;

import java.util.Random;

public class Contractor extends Employee {
    private final int paymentForHour;
    public Contractor(String name,int paymentForHour) {
        super(name);
        this.paymentForHour = paymentForHour;
    }

    public boolean desire(){
        Random random = new Random();
        int result = random.nextInt(2);
        return result == 0;
    }

    @Override
    public void nextHour(DateTime dateTime) {
        if (haveTask()){
            if (dateTime.dayOff()){
                getCurrentTask().minusHour(1);
                plusToTimeSpent(1);
                System.out.println(getName() + " Отрабатывает " + getCurrentTask().getDuration() + " ч.");
            } else if (desire()){
                getCurrentTask().minusHour(1);
                plusToTimeSpent(1);
                System.out.println(getName() + " Решил поработать в выходной " + getCurrentTask().getDuration() + " ч.");
            }else System.out.println(getName() + " отдыхает");
        }
        if (isFree()){
            reportTaskListener();
        }
        if(dateTime.getDayOfMonth() == dateTime.getSizeMonth()) {
            calculatedSalary();
        }
    }
    @Override
    public int calculatedSalary(){
        return paymentForHour * getTimeSpent();
    }

}
