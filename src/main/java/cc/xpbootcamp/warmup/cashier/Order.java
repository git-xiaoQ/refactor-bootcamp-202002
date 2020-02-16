package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String customer_address;
    List<LineItem> lineItemList;

    public Order(String customerName, String customer_address, List<LineItem> lineItemList) {
        this.customerName = customerName;
        this.customer_address = customer_address;
        this.lineItemList = lineItemList;
    }

    private String getCustomerName() {
        return customerName;
    }

    private String getCustomerAddress() {
        return customer_address;
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

    public StringBuilder getOrderDetail(StringBuilder output) {
        // print customer name and customer address
        if (getCustomerName() != null) {
            output.append(getCustomerName());
        }
        if (getCustomerAddress() != null) {
            output.append(getCustomerAddress());
        }

        // prints lineItems
        for (LineItem lineItem : getLineItems()) {
            output = lineItem.getLineItemDetail(output);
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(getTotalSalesTax(.10));

        // print total amount
        output.append("Total Amount").append('\t').append(getTotalAmountWithTax(.10));
        return output;
    }
}
