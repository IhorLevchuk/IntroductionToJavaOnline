package unit06.task03;

import unit06.task03.Client.Client;
import unit06.task03.Server.Access;
import unit06.task03.Server.ParserXML;
import unit06.task03.Server.Profile;
import unit06.task03.Server.Server;

import java.util.ArrayList;

public class Task03 {
    /*
    Попробуйте решить данную задачу хотя бы на 50%.
Задание 3: создайте клиент-серверное приложение “Архив”.
Общие требования к заданию:
• В архиве хранятся Дела (например, студентов). Архив находится на сервере.
• Клиент, в зависимости от прав, может запросить дело на просмотр, внести в него изменения, или создать новое дело.
Требования к коду лабораторной работы:
• Для реализации сетевого соединения используйте сокеты.
• Формат хранения данных на сервере – xml-файлы.

      Admin: admin
             admin

      User:  user
             user
     */
    public static void main(String[] args) {
        new Server().start();
        new Client().start();

//        String pathProfileFile = "src/unit06/task03/resources/profiles.xml";
//
//        ArrayList<Profile> profiles = new ArrayList<>();
//        profiles.add(new Profile(Access.ADMIN, "Игорь Левчук", "admin","admin"));
//        profiles.add(new Profile(Access.USER, "Григорий Данев", "user","user"));
//
//        ParserXML.writeProfilesInXML(profiles, pathProfileFile);
    }
}
