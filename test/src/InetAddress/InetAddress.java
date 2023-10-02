package InetAddress;

import java.util.Calendar;

public class InetAddress {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        System.out.println(today.get(Calendar.YEAR));
        System.out.println(today.get(Calendar.MONTH)+1);
    }
}
