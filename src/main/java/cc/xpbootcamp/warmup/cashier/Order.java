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

    private double getTotalSalesDiscount(double rate, double discount) {
        return getTotalAmountWithTax(rate) * (1 - discount);
    }

    private boolean isDiscount(){
        return time.getWeek().equals("星期三");
    }

    StringBuilder getOrderFooter(StringBuilder output,double rate,double discount) {
        output.append("税额：").append(CashierUtil.formatDigit(getTotalSalesTax(rate))).append('\n');
        if (isDiscount()) {
            output.append("折扣：").append(CashierUtil.formatDigit(getTotalSalesDiscount(rate, discount))).append('\n');
            output.append("总价：").append(CashierUtil.formatDigit(getTotalAmountAfterDiscount(rate, discount)));
        } else {
            output.append("总价：").append(CashierUtil.formatDigit(getTotalAmountWithTax(rate)));
        }
        return output;
    }

    StringBuilder getOrderItems(StringBuilder output){
        for (LineItem lineItem : getLineItems()) {
            output.append(lineItem.getLineItemDetail());
        }
        return output;
    }

    StringBuilder getOrderTime(StringBuilder output){
        output.append(time.getDate());
        output.append('，');
        output.append(time.getWeek());
        output.append('\n');
        return output;
    }

    StringBuilder getOrderHead(StringBuilder output){
        if (customer != null) {
            output.append(customer.getCustomerDetail());
        }
        return output;
    }

}
