package by.epam.introduction_to_java.unit05.task03.bean;

import java.io.Serial;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calendar implements Serializable {
    @Serial
    private static final long serialVersionUID = 8176662519376189853L;

    private LocalDate startInclusive;
    private LocalDate endInclusive;
    private List<WeekendOrHoliday> weekendAndHoliday;

    public Calendar(LocalDate startInclusive, LocalDate endInclusive) {
        this.weekendAndHoliday = new ArrayList<>();
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public Calendar() {
    }

    public LocalDate getStartInclusive() {
        return startInclusive;
    }

    public void setStartInclusive(LocalDate startInclusive) {
        this.startInclusive = startInclusive;
    }

    public LocalDate getEndInclusive() {
        return endInclusive;
    }

    public void setEndInclusive(LocalDate endInclusive) {
        this.endInclusive = endInclusive;
    }

    public List<WeekendOrHoliday> getWeekendAndHoliday() {
        return weekendAndHoliday;
    }

    public void setWeekendAndHoliday(List<WeekendOrHoliday> weekendAndHoliday) {
        this.weekendAndHoliday = weekendAndHoliday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return Objects.equals(startInclusive, calendar.startInclusive) && Objects.equals(endInclusive, calendar.endInclusive) && Objects.equals(weekendAndHoliday, calendar.weekendAndHoliday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startInclusive, endInclusive, weekendAndHoliday);
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "startInclusive=" + startInclusive +
                ", endInclusive=" + endInclusive +
                ", weekendAndHoliday=" + weekendAndHoliday +
                '}';
    }

    public static class WeekendOrHoliday implements Serializable{
        @Serial
        private static final long serialVersionUID = 6583633230177583670L;

        LocalDate date;
        String nameHoliday;

        public WeekendOrHoliday(LocalDate date, String nameHoliday) {
            this.date = date;
            this.nameHoliday = nameHoliday;
        }

        public WeekendOrHoliday() {
        }

        @Override
        public String toString() {
            return "WeekendOrHoliday{" +
                    "date=" + date +
                    ", nameHoliday='" + nameHoliday + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WeekendOrHoliday that = (WeekendOrHoliday) o;
            return Objects.equals(date, that.date) && Objects.equals(nameHoliday, that.nameHoliday);
        }

        @Override
        public int hashCode() {
            return Objects.hash(date, nameHoliday);
        }
    }
}
