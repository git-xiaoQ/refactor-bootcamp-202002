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

    List<LineItem> getLineItems() {
        return lineItemList;
    }

    Customer getCustomer(){ return customer; }

    Time getTime() { return time; }

    double getTotalSalesTax(double rate) {
        double totalSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.getSalesTax(rate);
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    double getTotalAmountWithTax(double rate) {
        double totalAmountWithTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.getSalesTax(rate);
            totalAmountWithTax += lineItem.totalAmount() + salesTax;
        }
        return totalAmountWithTax;
    }

    double getTotalAmountAfterDiscount(double rate, double discount) {

        return getTotalAmountWithTax(rate) * discount;
    }

    double getTotalSalesDiscount(double rate, double discount) {
        return getTotalAmountWithTax(rate) * (1 - discount);
    }

    boolean isDiscount(){
        return time.getWeek().equals("星期三");
    }
}
