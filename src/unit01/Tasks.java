package unit01;
import java.util.Scanner;

public class Tasks {
    public static void main(String[] args) {
        String taskNumber;

        System.out.println("Select task number:");
        Scanner in = new Scanner(System.in);
        taskNumber = in.next();

        switch (taskNumber) {
            case "1.1" -> {
                Task1_1 task01 = new Task1_1();
                System.out.println(task01.calculatingTheValue());
            }
            case "1.2" -> {
                Task1_2 task12 = new Task1_2();
                System.out.println(task12.calculatingTheValue());
            }
            case "1.3" -> {
                Task1_3 task03 = new Task1_3();
                System.out.println(task03.calculatingTheValue());
            }
            case "1.4" -> {
                Task1_4 task04 = new Task1_4();
                System.out.println(task04.changeNumber());
            }
            case "1.5" -> {
                Task1_5 task05 = new Task1_5();
                task05.printFormate();
            }
            case "1.6" -> {
                Task1_6 task06 = new Task1_6();
                System.out.println(task06.definitionOfOccurrence());
            }
            case "2.1" -> {
                Task2_1 task07 = new Task2_1();
                task07.calculatingOfAngles();
                System.out.printf("Triangle: %b \nRight Triangle: %b", task07.isTriangle(), task07.isRightTriangle() );
            }
            case "2.2" -> {
                Task2_2 task08 = new Task2_2();
                System.out.println("Max =" + task08.findingTheMax());
            }
            case "2.3" -> {
                Task2_3 task09 = new Task2_3();
                System.out.println(task09.establishingPosition());
            }
            case "2.4" -> {
                Task2_4 task10 = new Task2_4();
                System.out.println(task10.checkingPassage());
            }
            case "2.5" -> {
                Task2_5 task11 = new Task2_5();
                System.out.println(task11.computation());
            }
            case "3.1" -> {
                Task3_1 task12 = new Task3_1();
                task12.summation();
                System.out.println(task12.getSum());
            }
            case "3.2" -> {
                Task3_2 task13 = new Task3_2();
                for (double mas : task13.computation()){
                    System.out.println(mas);
                }
            }
            case "3.3" -> {
                Task3_3 task14 = new Task3_3();
                System.out.println(task14.getSum());
            }
            case "3.4" -> {
                Task3_4 task15 = new Task3_4();
                System.out.println(task15.getProductionNumbers());
            }
            case "3.5" -> {
                Task3_5 task16 = new Task3_5();
                System.out.println(task16.getSum());
            }
            case "3.6" -> {
                Task3_6 task17 = new Task3_6();
                task17.output();
            }
            case "3.7" -> {
                Task3_7 task18 = new Task3_7();
                task18.findingDivisors();
            }
            case "3.8" -> {
                Task3_8 task19 = new Task3_8();
                task19.establishmentEntry();
            }
            default -> System.out.println("Task not found");
        }

    }
}
