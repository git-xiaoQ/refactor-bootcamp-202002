package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;

class CashierUtil {

    static String formatDigit(double digit) {
        DecimalFormat doubleFormat = new DecimalFormat("0.00");
        return doubleFormat.format(digit);
    }


}
