package dateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class DateTest {
    public static void main(String[] args)  {
        Date date1990 = new Date();
        date1990.setYear(121); //1900년부터 시작점이기때문에 전달한 정수와 더하여 년도가 설정된다.
        date1990.setMonth(11); //1900년부터 시작점이기때문에 전달한 정수와 더하여 년도가 설정된다.

//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(date);
//        Date today = new Date();
////        System.out.println(today);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
//        System.out.println(sdf.format(today));
        Date todayofPrint = new Date();
        SimpleDateFormat sbc = new SimpleDateFormat("yyyy년/MM월/dd일 HH:mm:ss");
        String pring= sbc.format(todayofPrint);
//        System.out.println(pring);

        try{
            System.out.println(sbc.parse("2023년/02월/18일 16:44:23"));
        }catch (ParseException e){;}
    }
}
