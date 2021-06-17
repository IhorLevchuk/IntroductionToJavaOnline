package by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.main;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.bean.Bank;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.service.BankAction;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task04.view.BankView;

public class Task04 {
    public static void main(String[] args) {
        /*
        Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
всем счетам, имеющим положительный и отрицательный балансы отдельно.
         */
        BankAction bankAction = new BankAction();
        BankView bankView = new BankView();

        Bank aSBBank = new Bank();

        bankAction.addCustomer(aSBBank,584,"Игорь", "Левчук","Юрьевич","Гомель");
        bankAction.addAccount(aSBBank,584,987413589L);
        bankAction.addAccount(aSBBank,584,987413590L);
        bankAction.addAccount(aSBBank,584,987413591L);
        bankAction.changeOfAccountAmount(aSBBank,987413589L,700);
        bankAction.accountLock(aSBBank, 987413590L);
        bankAction.changeOfAccountAmount(aSBBank, 987413590L,-5);
        bankAction.changeOfAccountAmount(aSBBank, 987413590L,-1000);


        bankAction.addCustomer(aSBBank,985,"Владимир", "Викторович","Утин","Москва");
        bankAction.addAccount(aSBBank,985,987413592L);
        bankAction.addAccount(aSBBank,985,987413593L);
        bankAction.addAccount(aSBBank,985,987413594L);
        bankAction.changeOfAccountAmount(aSBBank, 987413593L,5000);
        bankAction.changeOfAccountAmount(aSBBank, 987413594L,55000);

        System.out.println(bankAction.getBalance(aSBBank));
        System.out.println(bankAction.getPositiveBalance(aSBBank));
        System.out.println(bankAction.getNegativeBalance(aSBBank));

        bankAction.sortAccounts(aSBBank);
        System.out.println(bankView.getAccounts(aSBBank));
        System.out.println(bankAction.searchAccounts(aSBBank, 584));

        System.out.println(bankView.getCustomers(aSBBank));


    }
}
