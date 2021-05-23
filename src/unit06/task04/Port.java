package unit06.task04;

import javax.resource.ResourceException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Port {
    private String name;
    private Queue<Dock> docks;
    private Queue<Container> storage;
    private Semaphore semaphore;
    private int capacity;

    public Port(String name, int capacity, ArrayList<Dock> docks, ArrayList<Container> storage) {
        this.semaphore = new Semaphore(docks.size(),true);
        this.storage = new ArrayDeque<>();
        this.storage.addAll(storage);
        this.docks = new ArrayDeque<>(docks);
        this.name = name;
        this.capacity = capacity;
    }

    public Dock dock() throws ResourceException {
        try {
            semaphore.acquire();
            return docks.poll();
        } catch (InterruptedException e) {
            throw new ResourceException(e);
        }
    }

    public void depart(Dock dock){
        docks.add(dock);
        semaphore.release();
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

    @Override
    public String toString() {
        return "Порт " + name +
                ", причалов: " + docks.size() +
                ", вместимость: " + capacity +
                ", контейнеров: " + storage.size();
    }

    public void printStorage() {
        StringBuilder string = new StringBuilder();
        string.append("Контэйнеры в порту:").append("\n");
        for (Container container: storage){
            string.append(container.getId()).append("\n");
        }
        System.out.println(string);
    }
}
