package org.example.calendarVSlocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Main5 {
    public static void main(String[] args) {
        //Dates
        Calendar c= Calendar.getInstance();
        c.set(2023,Calendar.JULY,22);

        LocalDate date= LocalDate.of(2023, Month.JULY,22);
        //times
        LocalTime time= LocalTime.of(01,50);

        //Date Time
        LocalDateTime dateTime= LocalDateTime.of(date,time);
        LocalDateTime dateTime1= LocalDateTime.of(2023,Month.JULY,23,2,45);
        //restar dias
        LocalDateTime lastWeek = dateTime.minusDays(7);
        //sumar dias
        dateTime.plusDays(3);
        String format = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);

        System.out.println(format);


    }
}
