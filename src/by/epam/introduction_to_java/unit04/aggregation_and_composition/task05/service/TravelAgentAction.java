package by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.service;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.bean.TravelAgent;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.bean.Voucher;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.enumeration.Transport;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.enumeration.TypeOfFood;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.enumeration.TypeOfVoucher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TravelAgentAction {

    public List<Voucher> getProperVoucher(TravelAgent travelAgent, TypeOfVoucher type, Transport transport, TypeOfFood food, int numberOfDays){
        return (ArrayList<Voucher>) travelAgent.getVouchers().stream()
                .filter(v -> v.getType().equals(type) && v.getTransport().equals(transport) && v.getFood().equals(food) && v.getNumberOfDays() == numberOfDays)
                .collect(Collectors.toList());
    }


    public ArrayList<Voucher> getProperVoucher(TravelAgent travelAgent, TypeOfFood food){
        return (ArrayList<Voucher>) travelAgent.getVouchers().stream()
                .filter(v -> v.getFood().equals(food)).collect(Collectors.toList());
    }


    public List<Voucher> sortByFood(List<Voucher> vouchers){
        vouchers.sort(Comparator.comparing(Voucher::getFood));
        return vouchers;
    }

    public List<Voucher> sortByTransport(List<Voucher> vouchers){
        vouchers.sort(Comparator.comparing(Voucher::getTransport));
        return vouchers;
    }

    public List<Voucher> sortByType(List<Voucher> vouchers){
        vouchers.sort(Comparator.comparing(Voucher::getType));
        return vouchers;
    }

    public List<Voucher> sortByPrice(List<Voucher> vouchers){
        vouchers.sort(Comparator.comparing(Voucher::getPrice));
        return vouchers;
    }
}
