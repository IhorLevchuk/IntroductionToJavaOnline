package unit05.task05.A.floral_arrangement;

import unit05.task05.A.flowers.CreatorFlower;
import unit05.task05.A.flowers.Flower;
import unit05.task05.A.packaging.CreatorWrapper;
import unit05.task05.A.packaging.Wrapper;

import java.util.ArrayList;

public class FloralArrangement {
    private ArrayList<Flower> flowers;
    private Wrapper wrapper;

    public FloralArrangement() {
        this.flowers = new ArrayList<>();
    }

    public void addFlower(String typeFlower, int number){
        for (int i = 0; i < number; i ++){
            flowers.add(CreatorFlower.createFlower(typeFlower));
        }
    }

    public void addWrapper(String typeWrapper){
        wrapper = CreatorWrapper.createWrapper(typeWrapper);
    }


    @Override
    public String toString() {
        return "FloralArrangement{" +
                "flowers=" + flowers +
                ", wrapper=" + wrapper +
                '}';
    }
}
