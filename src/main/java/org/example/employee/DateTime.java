package org.example.employee;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DateTime {
    LocalDateTime dateTime;
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

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
