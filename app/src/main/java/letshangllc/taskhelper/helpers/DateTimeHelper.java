package letshangllc.taskhelper.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Carl on 10/30/2016.
 */

public class DateTimeHelper {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());

    public static String getFormattedDate(Calendar calendar){
        return dateFormat.format(calendar.getTime());
    }

    public static String getFormattedTime(int hour, int minutes){
        String dayPart = "AM";
        if(hour == 24){
            hour = 12;
        } else if(hour >= 12){
            hour %=12;
            dayPart = "PM";
            if(hour == 0){
                hour = 12;
            }
        }
        return String.format(Locale.getDefault(), "%02d:%02d %s", hour, minutes, dayPart);
    }

}
