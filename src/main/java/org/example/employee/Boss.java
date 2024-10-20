package org.example.employee;

import java.util.ArrayList;

public class Boss {
    private final ArrayList<Employee> employees = new ArrayList<>();

    private final ArrayList<Task> toDoList = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
         employees.add(employee);
         return employee;
    }
    public void nextHour(int number) {
        for(Employee employee : employees){
            if(employee.haveTask()) {
                employee.getCurrentTask().minusHour(number);
                employee.plusToTimeSpent(number);
            }
        }

    }
    public void showSalary() {
        for(Employee employee : employees){
            System.out.println("Сотрудник: " + employee.getName());
            System.out.println("Зарплата: " + employee.calculatedSalary());
        }
    }
    public boolean haveTaskInToDoList() {
        return !toDoList.isEmpty();
    }
    public boolean haveEmployeeWork() {
        for (Employee employee : employees) {
            if(employee.haveTask()) {
                return true;
            }
        }
        return false;
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
    public void giveTaskFreeEmployeeForToDoList(){
        if (haveTaskInToDoList()){
            findFreeEmployee().setCurrentTask(toDoList.getFirst());
            toDoList.removeFirst();
        }
    }
    public void giveTaskFromToDoList(){
        if (haveFreeEmployee()){
            giveTaskFreeEmployeeForToDoList();
        }
    }

}
