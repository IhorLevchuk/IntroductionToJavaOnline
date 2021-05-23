package unit02;
import java.util.Scanner;

public class Tasks {
    public static void main(String[] args){
        System.out.println("Select task:");
        Scanner in = new Scanner(System.in);
        switch (in.nextLine()) {
            case "1.1" -> {
                Task1_1 task1_1 = new Task1_1();
                System.out.println(task1_1.summation());
            }
            case "1.2" -> {
                Task1_2 task1_2 = new Task1_2();
                task1_2.calculating();
            }
            case "1.3" -> {
                Task1_3 task1_3 = new Task1_3();
                task1_3.calculating();
            }
            case "1.4" -> {
                Task1_4 task1_4 = new Task1_4();
                task1_4.calculating();
            }
            case "1.5" -> {
                Task1_5 task1_5 = new Task1_5();
                task1_5.calculating();
            }
            case "1.6" -> {
                Task1_6 task1_6 = new Task1_6();
                task1_6.calculating();
            }
            case "1.7" -> {
                Task1_7 task1_7 = new Task1_7();
                task1_7.calculating();
            }
            case "1.8" -> {
                Task1_8 task1_8 = new Task1_8();
                task1_8.calculating();
            }
            case "1.9" -> {
                Task1_9 task1_9 = new Task1_9();
                task1_9.calculating();
            }
            case "1.10" -> {
                Task1_10 task1_10 = new Task1_10();
                task1_10.calculating();
            }
            case "2.1" -> {
                Task2_1 task2_1 = new Task2_1();
                task2_1.calculating();
            }
            case "2.2" -> {
                Task2_2 task2_2 = new Task2_2();
                task2_2.calculating();
            }
            case "2.3" -> {
                Task2_3 task2_3 = new Task2_3();
                task2_3.calculating();
            }
            case "2.4" -> {
                Task2_4 task2_4 = new Task2_4();
                task2_4.calculating();
            }
            case "2.5" -> {
                Task2_5 task2_5 = new Task2_5();
                task2_5.calculating();
            }
            case "2.6" -> {
                Task2_6 task2_6 = new Task2_6();
                task2_6.calculating();
            }
            case "2.7" -> {
                Task2_7 task2_7 = new Task2_7();
                task2_7.calculating();
            }
            case "2.8" -> {
                Task2_8 task2_8 = new Task2_8();
                task2_8.calculating();
            }
            case "2.9" -> {
                Task2_9 task2_9 = new Task2_9();
                task2_9.calculating();
            }
            case "2.10" -> {
                Task2_10 task2_10 = new Task2_10();
                task2_10.calculating();
            }
            case "2.11" -> {
                Task2_11 task2_11 = new Task2_11();
                task2_11.calculating();
            }
            case "2.12" -> {
                Task2_12 task2_12 = new Task2_12();
                task2_12.calculating();
            }
            case "2.13" -> {
                Task2_13 task2_13 = new Task2_13();
                task2_13.calculating();
            }
            case "2.14" -> {
                Task2_14 task2_14 = new Task2_14();
                task2_14.calculating();
            }
            case "2.15" -> {
                Task2_15 task2_15 = new Task2_15();
                task2_15.calculating();
            }
            case "2.16" -> {
                Task2_16 task2_16 = new Task2_16();
                task2_16.calculating();
            }
            case "3.1" -> {
                Task3_1 task3_1 = new Task3_1();
                task3_1.calculating();
            }
            case "3.2" -> {
                Task3_2 task3_2 = new Task3_2();
                task3_2.calculating();
            }
            case "3.3" -> {
                Task3_3 task3_3 = new Task3_3();
                task3_3.calculating();
            }
            case "3.4" -> {
                Task3_4 task3_4 = new Task3_4();
                task3_4.calculating();
            }
            case "3.5" -> {
                Task3_5 task3_5 = new Task3_5();
                task3_5.calculating();
            }
            case "3.6" -> {
                Task3_6 task3_6 = new Task3_6();
                task3_6.calculating();
            }
            case "3.7" -> {
                Task3_7 task3_7 = new Task3_7();
                task3_7.calculating();
            }
            case "3.8" -> {
                Task3_8 task3_8 = new Task3_8();
                task3_8.calculating();
            }
            case "4.1" -> {
                Task4_1 task4_1 = new Task4_1(60,30);
                task4_1.calculating();
                System.out.println(task4_1);
            }
            case "4.2" -> {
                Task4_2 task4_2 = new Task4_2(30,60,120,15);
                task4_2.calculating();
                System.out.println(task4_2);
            }
            case "4.3" -> {
                Task4_3 task4_3 = new Task4_3(3);
                System.out.println(task4_3.calculatingAreaHexagon());
            }
            case "4.4" -> {
                Task4_4 task4_4 = new Task4_4(3);
                task4_4.settingPoints();
                task4_4.findingGreatestDistance();
                System.out.println(task4_4);
            }
            case "4.5" -> {
                Task4_5 task4_5 = new Task4_5(10);
                task4_5.findElement();
                System.out.println(task4_5);
            }
            case "4.6" -> {
                Task4_6 task4_6 = new Task4_6(10,9,5);
                task4_6.complianceCheck();
                System.out.println(task4_6);
            }
            case "4.7" -> {
                Task4_7 task4_7 = new Task4_7();
                task4_7.summationFactorial();
                System.out.println(task4_7.getSumFactorial());
            }
            case "4.8" -> {
                Task4_8 task4_8 = new Task4_8();
                task4_8.createMas(10);
                task4_8.findSum(9);
                System.out.println(task4_8);
            }
            case "4.9" -> {
                Task4_9 task4_9 = new Task4_9(5,20,15,10);
                task4_9.findArea();
                System.out.println(task4_9);
            }
            case "4.10" -> {
                Task4_10 task4_10 = new Task4_10(568);
                task4_10.arrayFormation();
                System.out.println(task4_10);
            }
            case "4.11" -> {
                Task4_11 task4_11 = new Task4_11(57,74);
                task4_11.comparisonOfNumbers();
                System.out.println(task4_11);
            }
            case "4.12" -> {
                Task4_12 task4_12 = new Task4_12(21,10);
                task4_12.arrayFormation();
                System.out.println(task4_12);
            }
            case "4.13" -> {
                Task4_13 task4_13 = new Task4_13(20);
                task4_13.findingTwins();
                System.out.println(task4_13);
            }
            case "4.14" -> {
                Task4_14 task4_14 = new Task4_14(900);
                task4_14.findingArmstrongNumbers();
                System.out.println(task4_14);
            }
            case "4.15" -> {
                Task4_15 task4_15 = new Task4_15(2);
                task4_15.findingNumbers();
                System.out.println(task4_15);
            }
            case "4.16" -> {
                Task4_16 task4_16 = new Task4_16(1);
                task4_16.findingSumAndQuantity();
                System.out.println(task4_16);
            }
            case "4.17" -> {
                Task4_17 task4_17 = new Task4_17(24);
                task4_17.findingTheNumberOfSubtractions();
                System.out.println(task4_17);
            }
            default -> System.out.println("Task not found");
        }
        in.close();
    }
}
