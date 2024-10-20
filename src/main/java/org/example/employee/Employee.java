package org.example.employee;

public abstract class Employee {
    private String name;
    private int timeSpent;

    private Task currentTask = new Task(0);

    public Employee(String name){
        this.name = name;
    }
    public abstract int calculatedSalary();
    public Task setTask(Task task) {
        return task;
    }
    public boolean isFree() {
        return currentTask.getDuration() == 0;
    }
    public String getName(){
        return name;
    }
    public Task getCurrentTask() {
        return currentTask;
    }
    public boolean haveTask(){
        return currentTask.haveDurationHours();
    }
    public int plusToTimeSpent(int toPlus) {
        return timeSpent += toPlus;
    }
    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }
    public int getTimeSpent() {
        return timeSpent;
    }
}
