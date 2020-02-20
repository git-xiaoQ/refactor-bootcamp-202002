package cc.xpbootcamp.warmup.cashier;

public class Customer {
    private String customerName;
    private String customerAddress;

    public Customer(String customerName, String customer_address) {
        this.customerName = customerName;
        this.customerAddress = customer_address;
    }
    private String getCustomerName() {
        return customerName;
    }

    private String getCustomerAddress() {
        return customerAddress;
    }

    String getCustomerDetail(){
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
