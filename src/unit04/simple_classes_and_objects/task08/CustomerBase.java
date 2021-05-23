package unit04.simple_classes_and_objects.task08;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomerBase {
    private ArrayList<Customer> customerBase;

    public CustomerBase(ArrayList<Customer> customerBase) {
        this.customerBase = customerBase;
    }

    public CustomerBase() {
        this.customerBase = new ArrayList<>();
    }

    public void addCustomer(int id, String name, String surname, String patronymic, String address, String creditCardNumber, String bankAccountNumber){
        customerBase.add(new Customer(id, name, surname, patronymic, address, creditCardNumber, bankAccountNumber));
    }


    public ArrayList<Customer> sortName(){
        ArrayList<Customer> list = new ArrayList<>(customerBase);
        list.sort(Comparator.comparing(Customer::getSurname));
        return list;
    }

    public ArrayList<Customer> getCustomerByCreditCardRange(String min, String max ){
        ArrayList<Customer> list = new ArrayList<>();
        for (Customer customer : customerBase) {
            if (customer.getCreditCardNumber().compareTo(min) > 0
                    && customer.getCreditCardNumber().compareTo(max) < 0) {
                list.add(customer);
            }
        }
        return list;

    }

    public ArrayList<Customer> getCustomerBase() {
        if(customerBase.size() != 0) {
            System.out.println("База пуста");
        }
        return customerBase;
    }

    public String baseToString(ArrayList<Customer> base) {
        StringBuilder string = new StringBuilder();
        for(Customer customer: base){
            string.append(customer).append("\n");
        }
        return string.toString();
    }
}
