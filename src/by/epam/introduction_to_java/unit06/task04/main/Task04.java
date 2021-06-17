package by.epam.introduction_to_java.unit06.task04.main;



import by.epam.introduction_to_java.unit06.task04.bean.Container;
import by.epam.introduction_to_java.unit06.task04.bean.Port;
import by.epam.introduction_to_java.unit06.task04.bean.Ship;
import by.epam.introduction_to_java.unit06.task04.enumeration.PurposeOfArrival;
import by.epam.introduction_to_java.unit06.task04.generator.Generator;

import java.util.ArrayList;

public class Task04 {
    /*
    Попробуйте решить данную задачу хотя бы на 50%.
Задание 4. Многопоточность. Порт . Корабли заходят в порт для разгрузки/загрузки контейнеров.
Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным и превышающим заданную
грузоподъемность судна и вместимость порта. В порту работает несколько причалов. У одного причала может стоять один корабль.
Корабль может загружаться у причала или разгружаться.
     */
    public static void main(String[] args) {

        // Создание порта
        Port port = new Port("Сингапур", 15, Generator.docks(4), Generator.containers(5));

        // Создание кораблей
        Thread ship1 = new Thread(new Ship("Ластока", 40, PurposeOfArrival.LOADING, new ArrayList<Container>(),
                6, port));


        Thread ship2 = new Thread(new Ship("Солнышко", 20, PurposeOfArrival.LOADING, Generator.containers(5),
                4, port));


        Thread ship3 = new Thread(new Ship("Восток-1", 60, PurposeOfArrival.UNLOADING, Generator.containers(10),
                25, port));


        Thread ship4 = new Thread(new Ship("Лебедь", 25, PurposeOfArrival.UNLOADING, Generator.containers(10),
                2, port));


        System.out.println(port);
        // Запуск потоков
        try {
            ship1.start();
            Thread.sleep(20);
            ship2.start();
            Thread.sleep(20);
            ship3.start();
            Thread.sleep(20);
            ship4.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
