package org.example.employee;

import java.util.Random;

public class Task {
    private int durationHours;

    public Task(int durationHours){
        this.durationHours = durationHours;
    }

    public int getDuration() {
        return durationHours;
    }
    public static Task createRandomTask(){
        Random random = new Random();
        Task task = new Task(random.nextInt(1,8));
        return task;
    }
    public boolean haveDurationHours(){
        return durationHours > 0;
    }
    public int minusHour(int toMinus) {
        return durationHours -= toMinus;
    }

}
