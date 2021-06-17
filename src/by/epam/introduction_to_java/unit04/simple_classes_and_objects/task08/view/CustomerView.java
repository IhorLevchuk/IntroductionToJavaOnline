package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task08.view;

import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task08.bean.Customer;

import java.util.List;

public class CustomerView {

    public void printCustomers(List<Customer> base) {
        StringBuilder string = new StringBuilder();
        for(Customer customer: base){
            string.append(customer).append("\n");
        }
        System.out.println(string);
    }
}
