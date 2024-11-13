package org.example.employee;

import java.time.LocalDateTime;
public class EmployeeMain {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime(LocalDateTime.now());
        Boss boss = new Boss(dateTime);

        Contractor boris = new Contractor("Contractor", boss,250);
        boss.addEmployee(boris);

        Contractor maksim = new Contractor("Contractor", boss,250);
        boss.addEmployee(maksim);

        HiredEmployee gosha = new HiredEmployee("Hired", boss,40000);
        boss.addEmployee(gosha);

        for (int i = 0 ; i <= 100; i++) {
            boss.nextHour(1);
            Task task = Task.createRandomTask();
            boss.giveTask(task);
        }
        while (dateTime.getDateTime().isBefore(dateTime.getDateTime().plusMonths(3))) {
            boss.giveTaskFromToDoList(boris);
            boss.nextHour(1);
            dateTime.plusHour(1);
        }
        boss.showSalary();
    }
}

