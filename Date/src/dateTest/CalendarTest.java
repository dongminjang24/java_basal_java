package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        System.out.println(today);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(today.getTime()));

        today.set(Calendar.DATE,20);
        System.out.println(sdf.format(today.getTime()));

        today.set(2021,2,21,12,30,22);
        System.out.println(sdf.format(today.getTime()));
        System.out.println(today.get(Calendar.DATE));
    }
}
