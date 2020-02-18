package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    private Date date;

    Time(Date date) {
        this.date = date;
    }

    Time() {
        this.date = new Date();
    }

    String getWeek() {
        SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE");
        return weekFormat.format(date);
    }

    String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY年M月d日");
        return dateFormat.format(date);
    }
}
