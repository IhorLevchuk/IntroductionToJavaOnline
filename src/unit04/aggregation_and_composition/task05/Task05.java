package unit04.aggregation_and_composition.task05;

public class Task05 {
    public static void main(String[] args) {
        /*
        Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
         */

        TravelAgent honey = new TravelAgent();

        honey.addVoucher(new Voucher(TypeOfVoucher.BEACH,Transport.BUS,TypeOfFood.FRENCH,8,100,6842));
        honey.addVoucher(new Voucher(TypeOfVoucher.CRUISE,Transport.AIRPLANE,TypeOfFood.ARMENIAN,5,200,8433));
        honey.addVoucher(new Voucher(TypeOfVoucher.EXCURSION,Transport.WALKING,TypeOfFood.ITALIAN,4,300,6230));
        honey.addVoucher(new Voucher(TypeOfVoucher.SHOPPING,Transport.SHIP,TypeOfFood.ALL,12,800,6331));
        honey.addVoucher(new Voucher(TypeOfVoucher.SKI,Transport.BUS,TypeOfFood.RUSSIAN,2,20,63215));
        honey.addVoucher(new Voucher(TypeOfVoucher.BEACH,Transport.AIRPLANE,TypeOfFood.ARMENIAN,5,180,7941));


        honey.printVouchers(honey.sortByPrice(honey.getProperVoucher(TypeOfFood.ARMENIAN)));
        //honey.printVouchers();
        Customer customer1 = new Customer("Витя", "Соловьёв", 7941);
        honey.addCustomer(customer1);
    }
}
