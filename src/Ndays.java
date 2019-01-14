import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/12 11:13
 * @Description:
 */
public class Ndays {

    public static void getBeforeAfterDateDay(Date date, int day) {

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        int Year = cal.get(Calendar.YEAR);
        int Month = cal.get(Calendar.MONTH);
        int Day = cal.get(Calendar.DAY_OF_MONTH);

        int NewDay = Day + day;

        cal.set(Calendar.YEAR, Year);
        cal.set(Calendar.MONTH, Month);
        cal.set(Calendar.DAY_OF_MONTH, NewDay);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d= new Date(cal.getTimeInMillis());
        System.out.println(sdf.format(d));


    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        int i=sc.nextInt();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       getBeforeAfterDateDay(date,i);
    }
}
