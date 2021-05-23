package unit05.task03;

import java.time.LocalDate;

public class Task03 {
    public static void main(String[] args) {
        /*
        Создать класс Календарь с внутренним классом,
        с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
         */

        Calendar calendar = new Calendar(LocalDate.of(2021,5,1),LocalDate.of(2021,6,1));
        calendar.addHoliday(LocalDate.of(2021,5,9),"Victory Day");
        calendar.printWeekendAndHolidayDays();
    }
}
