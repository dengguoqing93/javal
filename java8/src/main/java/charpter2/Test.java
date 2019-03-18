package charpter2;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018/12/7
 */
public class Test {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2008, 11, 30);
        LocalDate localDate1 = LocalDate.of(2009, 12, 23);
        long l = System.currentTimeMillis();
        long daysBetween = getDaysBetween(localDate1, localDate);
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(daysBetween);
    }

    public static long getDaysBetween(LocalDate date1, LocalDate date2) {
        return date2.until(date1, ChronoUnit.DAYS);
        /*if (date1.isAfter(date2)) {
            return date1.toEpochDay() - date2.toEpochDay();
        } else {
            return date2.toEpochDay() - date1.toEpochDay();
        }*/

    }
}
