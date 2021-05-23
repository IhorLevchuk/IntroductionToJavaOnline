package unit06.task04;

import javax.resource.ResourceException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Ship implements Runnable {
    private final String name;
    private final int capacity;
    private final int numberOfContainersToBeProcessed;
    private final Queue<Container> storage;
    private final PurposeOfArrival purposeOfArrival;
    private final Port port;

    public Ship(String name, int capacity, PurposeOfArrival purposeOfArrival, ArrayList<Container> storage, int numberOfContainersToBeProcessed, Port port) {
        this.name = name;
        this.capacity = capacity;
        this.purposeOfArrival = purposeOfArrival;
        this.storage = new ArrayDeque<>(storage);
        this.numberOfContainersToBeProcessed = numberOfContainersToBeProcessed;
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println("Прибыл корабль " + name + ", вместимостью " + capacity + ", с " + storage.size()
                + " контейнерами на боту. " + purposeOfArrival + " " + numberOfContainersToBeProcessed + " контейнеров.");

        Dock dock = null;
        try {
            dock = port.dock();
            System.out.println("Корабль " + name + " причалил, причал " + dock.getNumber());
            if (purposeOfArrival.equals(PurposeOfArrival.LOADING)) {
                loadShip();
            } else {
                unLoadShip();
            }
        } catch (ResourceException e) {
            System.out.println("Ship " + name + " lost -> " + e.getMessage());
        } finally {
            System.out.println("Корабль " + name + " отчалил. Контейнеров на борту: " + storage.size());
            port.depart(dock);
        }
    }

    public void loadShip() {
        for (int i = 0; i < numberOfContainersToBeProcessed; i++){
            Container container = port.getContainer();
            if (container != null){
                if (storage.size()+1 <= capacity){
                    storage.add(container);
                    System.out.println("Корабль " + name + " загрузил контейнер, ID: " + container.getId());
                } else {
                    System.out.println("Достигнута максимальная вместимость корабля, загружено " + i+1);
                    while (port.setContainer(container));
                    return;
                }

            } else {
                System.out.println("В порту закончились контейнеры");
                return;
            }
        }
    }

    public void unLoadShip() {
        for (int i = 0; i < numberOfContainersToBeProcessed; i++){
            Container container = storage.poll();

            if(container != null){
                if (!port.setContainer(container)){
                    System.out.println("Достигнута максимальная вместимость порта, выгружено " + i);
                    storage.add(container);
                    return;
                }
                System.out.println("Корабль " + name + " разгрузил контейнер, ID: " + container.getId());
            } else {
                System.out.println("На корабле " + name + " закончились контейнеры, выгружено " + i);
                return;
            }

        }
    }
}
