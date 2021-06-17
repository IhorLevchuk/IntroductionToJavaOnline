package by.epam.introduction_to_java.unit05.task03.main;

import by.epam.introduction_to_java.unit05.task03.bean.Calendar;
import by.epam.introduction_to_java.unit05.task03.service.CalendarAction;
import by.epam.introduction_to_java.unit05.task03.view.CalendarView;

import java.time.LocalDate;

public class Task03 {
    public static void main(String[] args) {
        /*
        Создать класс Календарь с внутренним классом,
        с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
         */
        CalendarView calendarView = new CalendarView();
        CalendarAction calendarAction = new CalendarAction();

        Calendar calendar = new Calendar(LocalDate.of(2021,5,1),LocalDate.of(2021,6,1));
        calendarAction.addAllWeekend(calendar);
        calendarAction.addHoliday(calendar, LocalDate.of(2021,5,9),"Victory Day");
        calendarView.printWeekendAndHolidayDays(calendar);
    }
}
