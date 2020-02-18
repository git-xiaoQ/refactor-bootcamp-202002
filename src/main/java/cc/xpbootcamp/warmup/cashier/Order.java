package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private Customer customer;
    private List<LineItem> lineItemList;
    private Time time;

    Order(Customer customer, List<LineItem> lineItemList) {
        this.customer = customer;
        this.lineItemList = lineItemList;
        this.time = new Time();
    }

    Order(Customer customer, List<LineItem> lineItemList, Time time) {
        this.customer = customer;
        this.lineItemList = lineItemList;
        this.time = time;
    }

    private List<LineItem> getLineItems() {
        return lineItemList;
    }

    private double getTotalSalesTax(double rate) {
        double totalSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.getSalesTax(rate);
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    private double getTotalAmountWithTax(double rate) {
        double totalAmountWithTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.getSalesTax(rate);
            totalAmountWithTax += lineItem.totalAmount() + salesTax;
        }
        return totalAmountWithTax;
    }

    private double getTotalAmountAfterDiscount(double rate, double discount) {

        return getTotalAmountWithTax(rate) * discount;
    }

    String getOrderDetail(double rate, double discount) {
        StringBuilder output = new StringBuilder();

        if (customer != null) {
            output.append(customer.getCustomerDetail());
        }

        output.append(time.getDate());
        output.append('，');
        String week = time.getWeek();
        output.append(week);
        output.append('\n');

        for (LineItem lineItem : getLineItems()) {
            output.append(lineItem.getLineItemDetail());
        }
        output.append("-----------------------------------\n");

        output.append("税额：").append(CashierUtil.formatDigit(getTotalSalesTax(rate))).append('\n');
        if (week.equals("星期三")) {
            output.append("折扣：").append(CashierUtil.formatDigit(getTotalSalesDiscount(rate, discount))).append('\n');
            output.append("总价：").append(CashierUtil.formatDigit(getTotalAmountAfterDiscount(rate, discount)));
        } else {
            output.append("总价：").append(CashierUtil.formatDigit(getTotalAmountWithTax(rate)));
        }
        return output.toString();
    }

    private double getTotalSalesDiscount(double rate, double discount) {
        return getTotalAmountWithTax(rate) * (1 - discount);
    }

}
