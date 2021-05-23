package unit04.simple_classes_and_objects.task05;

public class Counter {
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

    @Override
    public String toString() {
        return "Counter:" +
                "min = " + min +
                ", max= " + max +
                ", counter= " + counter +
                ", step= " + step;
    }

    public void increase(){
        setCounter(counter+step);
    }

    public void decrease(){
        setCounter(counter-step);
    }

}
