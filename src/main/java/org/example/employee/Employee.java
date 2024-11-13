package org.example.employee;

import java.time.LocalDateTime;

public abstract class Employee implements Simulated {
    private String name;
    private int timeSpent;
    Boss boss;
    private Task currentTask = new Task(0);
    public Employee(String name, Boss boss) {
        this.name = name;
        this.boss = boss;
    }
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
    public void plusToTimeSpent(int toPlus) {
        timeSpent += toPlus;
    }
    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }
    public int getTimeSpent() {
        return timeSpent;
    }

}
