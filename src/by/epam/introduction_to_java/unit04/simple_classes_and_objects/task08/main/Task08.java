package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task08.main;

import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task08.dao.CustomerBase;
import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task08.view.CustomerView;


public class Task08 {
    public static void main(String[] args) {
        /*
        Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString().
        Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
        Задать критерии выбора данных и вывести эти данные на консоль.
        Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
Найти и вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
         */

        CustomerBase base = new CustomerBase();
        CustomerView customerView = new CustomerView();

        base.addCustomer(458, "Игорь", "Левчук", "Юрьевич", "Гомель",
                "123451234","845795216");
        base.addCustomer(459, "Влад", "Пушкин", "Витальевич", "Минск",
                "123456123","98433556");
        base.addCustomer(460, "Павел", "Седро", "Никитич", "Брест",
                "523456712","85331564");
        base.addCustomer(461, "Сергей", "Астапкин", "Дмитреивич", "Полоцк",
                "173456781","7856224");
        base.addCustomer(462, "Григорий", "Данев", "Валерьевич", "Гродно",
                "12345679","5795216");

        customerView.printCustomers(base.getCustomerBase());
        System.out.println("Список покупателей в алфавитном порядке: \n");
        customerView.printCustomers(base.sortName());
        System.out.println("Список покупателей, у которых номер кредитной карточки находится в заданном интервале \n");
        customerView.printCustomers(base.getCustomerByCreditCardRange("150000000","25000000"));
    }
}
