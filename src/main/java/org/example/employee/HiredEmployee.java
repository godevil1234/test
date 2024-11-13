package org.example.employee;

public class HiredEmployee extends Employee {
    private int fixedPayment;
    public HiredEmployee(String name, Boss boss, int fixedPayment) {
        super(name,boss);
        this.fixedPayment = fixedPayment;
    }

    @Override
    public void nextHour(int number) {
        if (haveTask()){
            if (!boss.getDateTime().dayOff()){
                getCurrentTask().minusHour(number);
                plusToTimeSpent(number);
            }
            else System.out.println("Работник отдыхает");
        }
        if (isFree()){
            boss.giveTaskFromToDoList(this);
        }
    }
    public int getFixedPayment() {
        return fixedPayment;
    }
}
