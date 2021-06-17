package by.epam.introduction_to_java.unit06.task04.generator;




import by.epam.introduction_to_java.unit06.task04.bean.Container;
import by.epam.introduction_to_java.unit06.task04.bean.Dock;

import java.util.ArrayList;

public class Generator {
    private static int counter = 1;

    public static ArrayList<Container> containers(int number){
        ArrayList<Container> containers = new ArrayList<>();
        for (int i = counter; i < number+counter; i++){
            containers.add(new Container("#"+i));
        }
        counter += containers.size();
        return containers;
    }

    public static ArrayList<Dock> docks(int number){
        ArrayList<Dock> docks = new ArrayList<>();
        for (int i = 1; i <= number; i++){
            docks.add(new Dock(i));
        }
        return docks;
    }
}
