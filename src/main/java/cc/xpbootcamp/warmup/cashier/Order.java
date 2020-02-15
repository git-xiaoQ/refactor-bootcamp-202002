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

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customer_address;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }
}
