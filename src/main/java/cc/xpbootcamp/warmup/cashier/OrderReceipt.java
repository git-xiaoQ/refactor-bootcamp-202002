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
    private static final double rate =0.10;
    private static final double discount =0.98;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        return  getTitle()+order.getOrderDetail(rate,discount);
    }

    private String getTitle() {
        return "======老王超市，值得信耐======\n";
    }

}