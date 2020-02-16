package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private String desc;
    private double price;
    private int qty;

    public LineItem(String desc, double price, int qty) {
        super();
        this.desc = desc;
        this.price = price;
        this.qty = qty;
    }

    public String getDescription() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return qty;
    }

    double totalAmount() {
        return price * qty;
    }

    public StringBuilder getLineItemDetail(StringBuilder output) {
    	output.append(getDescription());
        output.append('\t');
        output.append(getPrice());
        output.append('\t');
        output.append(getQuantity());
        output.append('\t');
        output.append(totalAmount());
        output.append('\n');

        return output;
    }
}