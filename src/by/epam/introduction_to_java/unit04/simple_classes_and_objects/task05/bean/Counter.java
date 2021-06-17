package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task05.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Counter implements Serializable {
    @Serial
    private static final long serialVersionUID = 3567218701205215103L;

    private int min;
    private int max;
    private int counter;
    private final int step;

    public void setCounter(int counter) throws IllegalArgumentException{
        if(counter <= max && counter >= min){
            this.counter = counter;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Counter(int min, int max, int counter, int step) {
        this.min = min;
        this.max = max;
        setCounter(counter);
        this.step = step;
    }

    public Counter() {
        this.min = 0;
        this.max = 10;
        this.counter = 5;
        this.step = 1;
    }

    public void increase(){
        setCounter(counter+step);
    }

    public void decrease(){
        setCounter(counter-step);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter1 = (Counter) o;
        return min == counter1.min && max == counter1.max && counter == counter1.counter && step == counter1.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, counter, step);
    }

    @Override
    public String toString() {
        return "Counter{" +
                "min=" + min +
                ", max=" + max +
                ", counter=" + counter +
                ", step=" + step +
                '}';
    }
}
