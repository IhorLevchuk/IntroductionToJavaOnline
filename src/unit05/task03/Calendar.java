package unit05.task03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Calendar {
    private final LocalDate startInclusive;
    private final LocalDate endInclusive;
    private final ArrayList<WeekendOrHoliday> weekendAndHoliday;

    public Calendar(LocalDate startInclusive, LocalDate endInclusive) {
        this.weekendAndHoliday = new ArrayList<>();
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        addAllWeekend();
    }

    private void addAllWeekend(){
        for (LocalDate i = startInclusive; !i.isAfter(endInclusive); i = i.plusDays(1)) {
            if (i.getDayOfWeek() == DayOfWeek.SUNDAY || i.getDayOfWeek() == DayOfWeek.SATURDAY) {
                weekendAndHoliday.add(new WeekendOrHoliday(i));
            }
        }
    }

    public void addHoliday(LocalDate date,String nameHoliday){
        weekendAndHoliday.add(new WeekendOrHoliday(date,nameHoliday));
    }

    public void printWeekendAndHolidayDays(){
        StringBuilder days = new StringBuilder();
        for (WeekendOrHoliday weekendOrHoliday: weekendAndHoliday){
            days.append(weekendOrHoliday).append("\n");
        }
        System.out.println(days);
    }

    static class WeekendOrHoliday{
        LocalDate date;
        String nameHoliday;

        public WeekendOrHoliday(LocalDate date, String nameHoliday) {
            this.date = date;
            this.nameHoliday = nameHoliday;
        }

        public WeekendOrHoliday(LocalDate date) {
            this.date = date;
        }

        @Override
        public String toString() {
            StringBuilder day = new StringBuilder();
            day.append(date).append(" ");
            if (this.nameHoliday != null) {
                day.append(nameHoliday);
                return day.toString();
            }
            day.append(date.getDayOfWeek());
            return day.toString();
        }
    }
}
