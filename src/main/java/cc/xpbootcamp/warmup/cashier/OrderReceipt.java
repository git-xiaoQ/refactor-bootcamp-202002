package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private static final double RATE =0.10d;
    private static final double DISCOUNT =0.98d;
    private static final String TITLE = "======老王超市，值得信赖======\n";

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(TITLE);
        output = order.getOrderHead(output);
        output = order.getOrderTime(output);
        output = order.getOrderItems(output);

        output.append("-----------------------------------\n");

        output = order.getOrderFooter(output,RATE,DISCOUNT);

        return output.toString();
    }
}