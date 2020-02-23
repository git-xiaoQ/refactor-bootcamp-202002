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
        String output = TITLE +
                getOrderHead() +
                getOrderTime() +
                getOrderItems() +
                "-----------------------------------\n" +
                getOrderSales(RATE, DISCOUNT);
        return output;
    }

    String getOrderHead(){
        Customer customer = order.getCustomer();
        if (customer != null) {
            return customer.getCustomerDetail();
        }
        return "";
    }

    String getOrderTime(){
        StringBuilder output = new StringBuilder();
        Time time  = order.getTime();
        output.append(time.getDate());
        output.append('，');
        output.append(time.getWeek());
        output.append('\n');
        return output.toString();
    }

    String getOrderItems(){
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getLineItemDetail());
        }
        return output.toString();
    }

    String getOrderSales(double rate,double discount) {
        StringBuilder output = new StringBuilder();
        output.append("税额：").append(CashierUtil.formatDigit(order.getTotalSalesTax(rate))).append('\n');
        if (order.isDiscount()) {
            output.append("折扣：").append(CashierUtil.formatDigit(order.getTotalSalesDiscount(rate, discount))).append('\n');
            output.append("总价：").append(CashierUtil.formatDigit(order.getTotalAmountAfterDiscount(rate, discount)));
        } else {
            output.append("总价：").append(CashierUtil.formatDigit(order.getTotalAmountWithTax(rate)));
        }
        return output.toString();
    }
}