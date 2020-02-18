package cc.xpbootcamp.warmup.cashier;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Customer customer = new Customer("Mr X", "Chicago, 60601");
        Order order = new Order(customer, new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);
        String output = receipt.printReceipt();

        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }


    @Test
    void shouldPrintItemNotWithDiscountPriceWhenDateNotTuesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-d");
        Date date = formatter.parse("2020-2-17");
        Time time = new Time(date);
        OrderReceipt receipt = new OrderReceipt(new Order(null, lineItems, time));
        String result = receipt.printReceipt();
        String except = "======老王超市，值得信耐======\n" +
                "2020年2月17日，星期一\n" +
                "巧克力, 21.50 x 2, 43.00\n" +
                "小白菜, 10.00 x 1, 10.00\n" +
                "-----------------------------------\n" +
                "税额：5.30\n" +
                "总价：58.30";
        Assert.assertEquals(except, result);

    }

    @Test
    void shouldPrintItemNotWithDiscountPriceWhenDateIsWednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-d");
        Date date = formatter.parse("2020-2-19");
        Time time = new Time(date);
        OrderReceipt receipt = new OrderReceipt(new Order(null, lineItems, time));
        String result = receipt.printReceipt();
        String except = "======老王超市，值得信耐======\n" +
                "2020年2月19日，星期三\n" +
                "巧克力, 21.50 x 2, 43.00\n" +
                "小白菜, 10.00 x 1, 10.00\n" +
                "-----------------------------------\n" +
                "税额：5.30\n" +
                "折扣：1.17\n" +
                "总价：57.13";
        Assert.assertEquals(except, result);

    }

}