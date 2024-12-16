package org.example.functionalProgramming;

public class DateTime extends Data {
    private int hours;
    private int minutes;
    private int seconds;

    public DateTime(int hours, int minutes, int seconds, int day, int month, int year) {
        super(day,month,year);
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }
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
        int day = (additionalHours + hours) / 24;
        addDays(day);
        hours = (additionalHours + hours) % 24;
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

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60) {
            this.seconds = seconds;
        }
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %02d.%02d.%02d", hours, minutes, seconds, day, month, year);
    }

    public static void main(String[] args) {
        DateTime dateTime = new DateTime(20,0,0,23,6,2024);
        dateTime.addDays(0);
        dateTime.addHours(12);
        System.out.println(dateTime);
    }
}
