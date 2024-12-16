package org.example.employee;

public class HiredEmployee extends Employee {
    private int fixedPayment;
    public HiredEmployee(String name, int fixedPayment) {
        super(name);
        this.fixedPayment = fixedPayment;
    }

    @Override
    public void nextHour(DateTime dateTime) {
        if (haveTask()){
            if (dateTime.dayOff()){
                getCurrentTask().minusHour(1);
                plusToTimeSpent(1);
                System.out.println(getName() + " Отрабатывает " + getCurrentTask().getDuration() + " ч.");
            }
            else System.out.println(getName() + " отдыхает");
        }
        if (isFree()) {
            reportTaskListener();
        }
        if (dateTime.getDateTime().getDayOfMonth() == 5 && dateTime.getDateTime().getHour() == 0 ||
                dateTime.getDateTime().getDayOfMonth() == 20 && dateTime.getDateTime().getHour() == 0)  {
            calculatedSalary();
            System.out.println(getName() + " Выплачена зарплата!");
        }

    }
    @Override
    public int calculatedSalary(){
        return fixedPayment += fixedPayment;
    }
}
