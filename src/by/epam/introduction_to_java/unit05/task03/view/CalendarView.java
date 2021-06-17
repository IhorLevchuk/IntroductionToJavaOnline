package by.epam.introduction_to_java.unit05.task03.view;

import by.epam.introduction_to_java.unit05.task03.bean.Calendar;

public class CalendarView {
    public void printWeekendAndHolidayDays(Calendar calendar){
        StringBuilder days = new StringBuilder();
        for (Calendar.WeekendOrHoliday weekendOrHoliday: calendar.getWeekendAndHoliday()){
            days.append(weekendOrHoliday).append("\n");
        }
        System.out.println(days);
    }
}
