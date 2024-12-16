package org.example.employee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements Simulated {
    private String name;
    private int timeSpent;
    private Task currentTask = new Task(0);
    private List<FinishedTaskListener> listeners = new ArrayList<>();
    void addListeners(FinishedTaskListener listener){
        this.listeners.add(listener);
    }
    public Employee(String name) {
        this.name = name;
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
    public abstract int calculatedSalary();
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
    public void reportTaskListener(){
        for(FinishedTaskListener listener : listeners){
            listener.onEmployeeFinishedTask(this);
        }
    }

}
