package by.epam.introduction_to_java.unit06.task04.service.impl;

import by.epam.introduction_to_java.unit06.task04.bean.Container;
import by.epam.introduction_to_java.unit06.task04.bean.Ship;
import by.epam.introduction_to_java.unit06.task04.logger.Logger;
import by.epam.introduction_to_java.unit06.task04.service.ShipServiceI;

public class ShipService implements ShipServiceI {

    @Override
    public void loadShip(Ship ship) {
        for (int i = 0; i < ship.getNumberOfContainersToBeProcessed(); i++){
            Container container = ship.getPort().getContainer();
            if (container != null){
                if (ship.getStorage().size()+1 <= ship.getCapacity()){
                    ship.getStorage().add(container);
                    Logger.log("Корабль " + ship.getName() + " загрузил контейнер, ID: " + container.getId());
                } else {
                    Logger.log("Достигнута максимальная вместимость корабля, загружено " + i+1);
                    return;
                }
            } else {
                Logger.log("В порту закончились контейнеры");
                return;
            }
        }
    }

    @Override
    public void unLoadShip(Ship ship) {
        for (int i = 0; i < ship.getNumberOfContainersToBeProcessed(); i++){
            Container container = ship.getStorage().poll();

            if(container != null){
                if (!ship.getPort().setContainer(container)){
                    Logger.log("Достигнута максимальная вместимость порта, выгружено " + i);
                    ship.getStorage().add(container);
                    return;
                }
                Logger.log("Корабль " + ship.getName() + " разгрузил контейнер, ID: " + container.getId());
            } else {
                Logger.log("На корабле " + ship.getName() + " закончились контейнеры, выгружено " + i);
                return;
            }
        }
    }
}
