package org.example;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours= hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // additionalSeconds -- количество секунд, которое нужно прибавить, при этом оно может быть больше 60
    // Time time = new Time(20, 18, 0);
    // time.addSeconds(100); // 20:19:40
    public void addSeconds(int additionalSeconds) {
        int additionalMinutes = (additionalSeconds + seconds) / 60;
        seconds = (additionalSeconds + seconds) % 60;
        addMinutes(additionalMinutes);
    }

    public void addMinutes(int additionalMinutes) {
        int additionalHours = (additionalMinutes + minutes) / 60;
        minutes = (additionalMinutes + minutes) % 60;
        addHours(additionalHours);
    }

    public void addHours(int additionalHours) {
        hours = (additionalHours + hours) % 24;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60) {
            this.seconds = seconds;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours < 24) {
            this.hours = hours;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        }
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        Time time = new Time(20, 18, 0);
        time.addSeconds(140);
        System.out.println(time);
    }
}
