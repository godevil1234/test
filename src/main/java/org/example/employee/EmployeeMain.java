package org.example.employee;

import java.time.LocalDateTime;
public class EmployeeMain {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime(LocalDateTime.now());
        Boss boss = new Boss(dateTime);

        LocalDateTime dateTimeFinish = dateTime.getDateTime().plusMonths(3);

        Contractor boris = new Contractor("Борис",250);
        boss.addEmployee(boris);
        boris.addListeners(boss);

        Contractor maksim = new Contractor("Максим",250);
        boss.addEmployee(maksim);
        maksim.addListeners(boss);

        HiredEmployee gosha = new HiredEmployee("Гоша",40000);
        boss.addEmployee(gosha);
        gosha.addListeners(boss);

        while (dateTime.getDateTime().isBefore(dateTimeFinish)) {
            dateTime.showDateTime();
            Task task = Task.createRandomTask();
            boss.giveTask(task);
            boss.nextHour(dateTime);
            dateTime.plusHour(1);
            System.out.println("--------------");
        }
        boss.showSalary();
    }
}

