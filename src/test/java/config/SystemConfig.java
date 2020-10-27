package config;



/**
 * @version 1.0-SNAPSHOT
 * @author  mbelhadjamara@iaaucarre.com
 * Class to management system environment properties
 */

public class SystemConfig
{
    /**
     * Method to get current machine OS name
     * @return os name
     */
    public static String getOS()
    {
        String OS = System.getProperty("os.name").toLowerCase();
        return OS;
    }

    /**
     * Check if the current OS is windows
     * @return true is the current OS is windows
     */
    public boolean isWindows()
    {
        String OS = getOS();
        return (OS.indexOf("win") >= 0);
    }

    /**
     * check if the current OS is MacOS
     * @return true if the current OS is MacOS
     */

    public boolean isMac()
    {
        String OS = getOS();
        return (OS.indexOf("mac") >= 0);
    }

    /**
     * Check if the current OS is a Linux system
     * @return true if the current OS  is a Linux system
     */
    public boolean isLinux() {
        String OS = getOS();
        return (OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

}
