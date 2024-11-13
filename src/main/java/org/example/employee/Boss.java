package org.example.employee;

import java.util.ArrayList;

public class Boss implements Simulated {
    private final ArrayList<Employee> employees = new ArrayList<>();

    private final ArrayList<Task> toDoList = new ArrayList<>();
    private DateTime dateTime;

    public DateTime getDateTime() {
        return dateTime;
    }

    public Boss(DateTime dateTime){
        this.dateTime = dateTime;
    }

    public Employee addEmployee(Employee employee) {
         employees.add(employee);
         return employee;
    }
    @Override
    public void nextHour(int numberHours) {
        for(Employee employee : employees){
            employee.nextHour(numberHours);
            employee.plusToTimeSpent(numberHours);
        }
        dateTime.plusHour(numberHours);
    }
    public void showSalary() {
        for(Employee employee : employees){
            System.out.println("Сотрудник: " + employee.getName());
            System.out.println("Зарплата: ");
        }
    }
    public boolean haveFreeEmployee() {
        for (Employee employee : employees) {
            if(!employee.haveTask()) {
                return true;
            }
        }
        return false;
    }
    private void addTaskInToDoList(Task task) {
        this.toDoList.add(task);
    }
    public void giveTask(Task task){
        if (haveFreeEmployee()){
            giveTaskToFreeEmployee(task);
        } else {
            addTaskInToDoList(task);
        }
    }
    public Employee findFreeEmployee() {
        for (Employee employee : employees) {
            if(employee.isFree()){
                return employee;
            }
        }
        return null;
    }
    public void giveTaskToFreeEmployee(Task task){
        findFreeEmployee().setCurrentTask(task);
    }
    public void giveTaskFromToDoList(Employee employee){
        if (!toDoList.isEmpty()){
            employee.setTask(toDoList.getFirst());
        }else System.out.println("Список отложенных задач пуст");
    }
    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

}
