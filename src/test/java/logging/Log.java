package logging;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log
{
    public static void INFO(String log)
    {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        int getLineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String getMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String getClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(
                sdf.format(cal.getTime()) + " [INFO] " + "[" +getClassName + " - " + getMethodName + ":" + getLineNumber + "]"
                        + " - " + log);
    }

    public static void ERROR(String log)
    {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        int getLineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String getMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String getClassName =Thread.currentThread().getStackTrace()[2].getClassName();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(
                sdf.format(cal.getTime()) + " [ERROR] " + "[" +getClassName + " - " + getMethodName + ":" + getLineNumber + "]"
                + " - " + log);

    }
}