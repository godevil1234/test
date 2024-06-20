package org.example;

public class Data {
    private int day;
    private int month;
    private int year;
    private static final int[] ALL_MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private Data (int day, int month, int year) {
        this.day = day;
        this.year = year;
        this.month = month;
    }
    @Override
    public String toString() {
        return String.format("%02d.%02d.%02d", day, month, year);
    }
    public static void main(String[] args) {
        Data data = new Data(20,6,2024);
        data.addDays(1000);
        System.out.println(data);
    }
    public void addDays (int additionalDays) {
        day += additionalDays;
        while (day > whichMonth()) {
            day -= whichMonth();
            addMonths(1);
        }
    }
    public void addMonths (int additionalMonths) {
        month += additionalMonths;
        while (month > 12) {
            month -= 12;
            addYears(1);
        }
    }
    public void addYears(int additionalYears) {
        year += additionalYears;
    }
    public int whichMonth() {
        if (month == 2 && leapYear(year)) {
            return 29;
        }
        return ALL_MONTHS[month];
    }
    public boolean leapYear(int year) {
        return year % 400 == 0 && year % 100 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
