package by.epam.introduction_to_java.unit05.task03.service;

import by.epam.introduction_to_java.unit05.task03.bean.Calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarAction {
    public void addHoliday(Calendar calendar, LocalDate date, String nameHoliday){
        calendar.getWeekendAndHoliday().add(new Calendar.WeekendOrHoliday(date,nameHoliday));
    }

    public void addAllWeekend(Calendar calendar){
        for (LocalDate i = calendar.getStartInclusive(); !i.isAfter(calendar.getEndInclusive()); i = i.plusDays(1)) {
            if (i.getDayOfWeek() == DayOfWeek.SUNDAY || i.getDayOfWeek() == DayOfWeek.SATURDAY) {
                calendar.getWeekendAndHoliday().add(new Calendar.WeekendOrHoliday(i, i.getDayOfWeek().toString()));
            }
        }
    }
}
