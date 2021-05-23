package unit01;
import java.util.Scanner;

public class Tasks {
    public static void main(String[] args) {
        String taskNumber;

        System.out.println("Select task number:");
        Scanner in = new Scanner(System.in);
        taskNumber = in.next();

        switch (taskNumber) {
            case "L1" -> {
                Task01 task01 = new Task01();
                System.out.println(task01.calculatingTheValue());
            }
            case "L2" -> {
                Task02 task02 = new Task02();
                System.out.println(task02.calculatingTheValue());
            }
            case "L3" -> {
                Task03 task03 = new Task03();
                System.out.println(task03.calculatingTheValue());
            }
            case "L4" -> {
                Task04 task04 = new Task04();
                System.out.println(task04.changeNumber());
            }
            case "L5" -> {
                Task05 task05 = new Task05();
                task05.printFormate();
            }
            case "L6" -> {
                Task06 task06 = new Task06();
                System.out.println(task06.definitionOfOccurrence());
            }
            case "B1" -> {
                Task07 task07 = new Task07();
                task07.calculatingOfAngles();
                System.out.printf("Triangle: %b \nRight Triangle: %b", task07.isTriangle(), task07.isRightTriangle() );
            }
            case "B2" -> {
                Task08 task08 = new Task08();
                System.out.println("Max =" + task08.findingTheMax());
            }
            case "B3" -> {
                Task09 task09 = new Task09();
                System.out.println(task09.establishingPosition());
            }
            case "B4" -> {
                Task10 task10 = new Task10();
                System.out.println(task10.checkingPassage());
            }
            case "B5" -> {
                Task11 task11 = new Task11();
                System.out.println(task11.computation());
            }
            case "C1" -> {
                Task12 task12 = new Task12();
                task12.summation();
                System.out.println(task12.getSum());
            }
            case "C2" -> {
                Task13 task13 = new Task13();
                for (double mas : task13.computation()){
                    System.out.println(mas);
                }
            }
            case "C3" -> {
                Task14 task14 = new Task14();
                System.out.println(task14.getSum());
            }
            case "C4" -> {
                Task15 task15 = new Task15();
                System.out.println(task15.getProductionNumbers());
            }
            case "C5" -> {
                Task16 task16 = new Task16();
                System.out.println(task16.getSum());
            }
            case "C6" -> {
                Task17 task17 = new Task17();
                task17.output();
            }
            case "C7" -> {
                Task18 task18 = new Task18();
                task18.findingDivisors();
            }
            case "C8" -> {
                Task19 task19 = new Task19();
                task19.establishmentEntry();
            }
            default -> System.out.println("Task not found");
        }

    }
}
