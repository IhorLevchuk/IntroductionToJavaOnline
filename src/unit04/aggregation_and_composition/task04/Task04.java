package unit04.aggregation_and_composition.task04;

public class Task04 {
    public static void main(String[] args) {
        /*
        Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
всем счетам, имеющим положительный и отрицательный балансы отдельно.
         */

        Bank aSBBank = new Bank();
        aSBBank.addCustomer(584,"Игорь", "Левчук","Юрьевич","Гомель");
        aSBBank.addAccount(584,987413589L);
        aSBBank.addAccount(584,987413590L);
        aSBBank.addAccount(584,987413591L);
        aSBBank.changeOfAccountAmount(987413589L,700);
        aSBBank.accountLock(987413590L);
        aSBBank.changeOfAccountAmount(987413590L,-5);
        aSBBank.changeOfAccountAmount(987413591L,-1000);


        aSBBank.addCustomer(985,"Владимир", "Владимирович","Утин","Москва");
        aSBBank.addAccount(985,987413592L);
        aSBBank.addAccount(985,987413593L);
        aSBBank.addAccount(985,987413594L);
        aSBBank.changeOfAccountAmount(987413593L,5000);
        aSBBank.changeOfAccountAmount(987413594L,55000);

        System.out.println(aSBBank.getBalance());
        System.out.println(aSBBank.getPositiveBalance());
        System.out.println(aSBBank.getNegativeBalance());

        aSBBank.sortAccounts();
        System.out.println(aSBBank.printAccounts());

        aSBBank.printAccounts(aSBBank.searchAccounts(584));

        System.out.println(aSBBank);


    }
}
