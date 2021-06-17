package by.epam.introduction_to_java.unit06.task04.bean;

import by.epam.introduction_to_java.unit06.task04.controller.ControllerProvider;
import by.epam.introduction_to_java.unit06.task04.enumeration.PurposeOfArrival;
import by.epam.introduction_to_java.unit06.task04.logger.Logger;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;

public class Ship implements Runnable, Serializable {
    @Serial
    private static final long serialVersionUID = -6030040952683672955L;

    ControllerProvider controllerProvider = ControllerProvider.getProvider();
    private String name;
    private int capacity;
    private int numberOfContainersToBeProcessed;
    private Queue<Container> storage;
    private PurposeOfArrival purposeOfArrival;
    private Port port;

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
        Logger.log("Прибыл корабль " + name + ", вместимостью " + capacity + ", с " + storage.size()
                + " контейнерами на боту. " + purposeOfArrival + " " + numberOfContainersToBeProcessed + " контейнеров.");
        Dock dock;
        dock = (Dock) controllerProvider.getPortController().doAction("dock",port);
        Logger.log("Корабль " + name + " причалил, причал " + dock.getNumber());
        controllerProvider.getShipController().doAction(purposeOfArrival,this);
        controllerProvider.getPortController().doAction("depart",port,dock);
        Logger.log("Корабль " + name + " отчалил. Контейнеров на борту: " + storage.size());
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfContainersToBeProcessed() {
        return numberOfContainersToBeProcessed;
    }

    public Queue<Container> getStorage() {
        return storage;
    }

    public PurposeOfArrival getPurposeOfArrival() {
        return purposeOfArrival;
    }

    public Port getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return capacity == ship.capacity && numberOfContainersToBeProcessed == ship.numberOfContainersToBeProcessed && Objects.equals(name, ship.name) && Objects.equals(storage, ship.storage) && purposeOfArrival == ship.purposeOfArrival && Objects.equals(port, ship.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity, numberOfContainersToBeProcessed, storage, purposeOfArrival, port);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", numberOfContainersToBeProcessed=" + numberOfContainersToBeProcessed +
                ", storage=" + storage +
                ", purposeOfArrival=" + purposeOfArrival +
                ", port=" + port +
                '}';
    }
}
