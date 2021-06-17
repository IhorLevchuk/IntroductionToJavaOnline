package by.epam.introduction_to_java.unit06.task04.bean;

import javax.resource.ResourceException;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Port implements Serializable {
    @Serial
    private static final long serialVersionUID = 7575823225868551548L;

    private String name;
    private Queue<Dock> docks;
    private Queue<Container> storage;
    private Semaphore semaphore;
    private int capacity;

    public Port(String name, int capacity, List<Dock> docks, List<Container> storage) {
        this.semaphore = new Semaphore(docks.size(),true);
        this.storage = new ArrayDeque<>();
        this.storage.addAll(storage);
        this.docks = new ArrayDeque<>(docks);
        this.name = name;
        this.capacity = capacity;
    }

    public Container getContainer(){
        return storage.poll();
    }

    public boolean setContainer(Container container){
        if (storage.size() <= capacity){
            storage.add(container);
            return true;
        } else return false;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public Queue<Dock> getDocks() {
        return docks;
    }

    public void setDocks(Queue<Dock> docks) {
        this.docks = docks;
    }

    @Override
    public String toString() {
        return "Port{" +
                "name='" + name + '\'' +
                ", docks=" + docks +
                ", storage=" + storage +
                ", semaphore=" + semaphore +
                ", capacity=" + capacity +
                '}';
    }

//    public void printStorage() {
//        StringBuilder string = new StringBuilder();
//        string.append("Контэйнеры в порту:").append("\n");
//        for (Container container: storage){
//            string.append(container.getId()).append("\n");
//        }
//        System.out.println(string);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Port port = (Port) o;
        return capacity == port.capacity && Objects.equals(name, port.name) && Objects.equals(docks, port.docks) && Objects.equals(storage, port.storage) && Objects.equals(semaphore, port.semaphore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, docks, storage, semaphore, capacity);
    }
}
