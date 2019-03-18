import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Git Tester.
 *
 * @author DGQ
 * @version 1.0
 * @since <pre>十月 15, 2018</pre>
 */

public class GitTest {
    @Test
    public void test() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = "2019-10-26";
        Date date1 = sdf.parse(stringDate);
        LocalDate localDate = LocalDate.parse("2019-10-25");
        Date date = new Date(localDate.getYear() - 1900, localDate.getMonthValue() - 1,
                             localDate.getDayOfMonth());
        System.out.println(!date1.after(date));
    }


} 
