package by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.view;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task05.bean.Voucher;

import java.util.List;

public class TravelAgentView {

    public void printVouchers(List<Voucher> vouchers){
        StringBuilder stringVouchers = new StringBuilder();
        for (Voucher voucher: vouchers){
            stringVouchers.append(voucher).append("\n");
        }
        System.out.println(stringVouchers);
    }
}
