package org.example.employee;
public class EmployeeMain {
    public static void main(String[] args) {
        Boss boss = new Boss();

        Contractor boris = new Contractor("Boris");
        boss.addEmployee(boris);

        Contractor maksim = new Contractor("Maksim");
        boss.addEmployee(maksim);

        HiredEmployee gosha = new HiredEmployee("Gosha");
        boss.addEmployee(gosha);

        for (int i = 0 ; i <= 100; i++) {
            boss.nextHour(1);
            Task task = Task.createRandomTask();
            boss.giveTask(task);
        }
        while (boss.haveTaskInToDoList() || boss.haveEmployeeWork()) {
            boss.giveTaskFromToDoList();
            boss.nextHour(1);
        }
        boss.showSalary();

    }
}
