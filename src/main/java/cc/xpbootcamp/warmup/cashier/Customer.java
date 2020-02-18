package cc.xpbootcamp.warmup.cashier;

public class Customer {
    private String customerName;
    private String customer_address;

    public Customer(String customerName, String customer_address) {
        this.customerName = customerName;
        this.customer_address = customer_address;
    }
    private String getCustomerName() {
        return customerName;
    }

    private String getCustomerAddress() {
        return customer_address;
    }

    String getCustomerDtail(){
        StringBuilder output = new StringBuilder();
        if (getCustomerName() != null) {
            output.append(getCustomerName());
        }
        if (getCustomerAddress() != null) {
            output.append(getCustomerAddress());
        }
        return output.toString();
    }
}
