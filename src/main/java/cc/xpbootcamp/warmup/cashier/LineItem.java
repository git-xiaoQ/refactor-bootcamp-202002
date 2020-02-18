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

    private String getDescription() {
        return desc;
    }

    private double getPrice() {
        return price;
    }

    private int getQuantity() {
        return qty;
    }

    double totalAmount() {
        return price * qty;
    }

    String getLineItemDetail() {
        StringBuilder output = new StringBuilder();
        output.append(getDescription());
        output.append(", ");
        output.append(CashierUtil.formatDigit(getPrice()));
        output.append(" x ");
        output.append(getQuantity());
        output.append(", ");
        output.append(CashierUtil.formatDigit(totalAmount()));
        output.append('\n');
        return output.toString();
    }

    double getSalesTax(double rate) {
        return totalAmount() * rate;
    }
}