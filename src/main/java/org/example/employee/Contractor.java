package org.example.employee;

import java.util.Random;

public class Contractor extends Employee {
    private final int paymentForHour;
    public Contractor(String name, Boss boss, int paymentForHour) {
        super(name,boss);
        this.paymentForHour = paymentForHour;
    }

    public boolean desire(){
        Random random = new Random();
        int result = random.nextInt(2);
        return result == 0;
    }

    @Override
    public void nextHour(int number) {
        if (haveTask()){
            if (!boss.getDateTime().dayOff()){
                getCurrentTask().minusHour(number);
                plusToTimeSpent(number);
            }else if (desire()){
                getCurrentTask().minusHour(number);
                plusToTimeSpent(number);
            }else System.out.println("Работник отдыхает");
        }
        if (isFree()){
            boss.giveTaskFromToDoList(this);
        }
    }
    public int getPaymentForHour() {
        return paymentForHour;
    }

}
