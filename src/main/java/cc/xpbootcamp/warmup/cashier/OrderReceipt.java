package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private Customer customer;

    OrderReceipt(Order order, Customer customer) {
        this.order = order;
        this.customer = customer;
    }


    String printReceipt() {
        StringBuilder output = new StringBuilder();

        if (customer != null) {
            output.append(customer.getCustomerDtail());
        }
        output.append(getTitle());
        output.append(order.getOrderDetail());
        return output.toString();
    }

    private String getTitle() {
        return "======老王超市，值得信耐======\n";
    }

}