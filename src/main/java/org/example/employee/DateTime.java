package org.example.employee;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    private LocalDateTime dateTime;
    public DateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public boolean dayOff(){
        return (dateTime.getDayOfWeek() == DayOfWeek.SATURDAY ||
                dateTime.getDayOfWeek() == DayOfWeek.SUNDAY ||
                dateTime.getDayOfYear() == 1);
    }
    public void plusHour(int numberHours){
        this.dateTime = this.dateTime.plusHours(numberHours);
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void showDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateTime.format(formatter);
        System.out.println("Дата и время: " + formattedDate);
    }
    public int getSizeMonth(){
        return dateTime.toLocalDate().lengthOfMonth();
    }
    public int getDayOfMonth(){
        return dateTime.getDayOfMonth();
    }
}
