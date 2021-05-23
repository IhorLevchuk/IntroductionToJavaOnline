package unit04.simple_classes_and_objects.task05;

public class Task05 {
    public static void main(String[] args) {
        /*
        Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу
        в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
        Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее получить его текущее состояние.
        Написать код, демонстрирующий все возможности класса.
         */
        try {
            Counter count = new Counter();
            System.out.println(count);
            count.increase();
            System.out.println(count);

            Counter count1 = new Counter(10,100,20,5);
            System.out.println(count1);
            count1.decrease();
            System.out.println(count1);
        } catch (IllegalArgumentException e){
            System.out.println("Счётчик выходит за пределы диапазона. " + e);
        }
    }
}

