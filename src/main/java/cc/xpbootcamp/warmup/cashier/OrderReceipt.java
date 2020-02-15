package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print customer name and customer address
        if(order.getCustomerName() != null){
            output.append(order.getCustomerName());
        }
        if(order.getCustomerAddress() != null){
            output.append(order.getCustomerAddress());
        }

        // prints lineItems
        double totalSalesTax = 0d;
        double totalAmountWithTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getlineItemDetailToString());
            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmountWithTax += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmountWithTax);
        return output.toString();
    }
}