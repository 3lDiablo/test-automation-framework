package config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



import static config.BrowserType.FIREFOX;

public class WebDriverManager
{

    private static final String driversBasePath = PropertyLoader.getInstance().getProperty("drivers");
    private static final String chromeDriverPath = PropertyLoader.getInstance().getProperty("driver.chrome");
    private static final String firefoxDriverPath = PropertyLoader.getInstance().getProperty("driver.firefox");

    static BrowserType browserType = BrowserType.getEnum(System.getProperty("browser","chrome"));

    private static WebDriver driver;

    public  static String getDriverPath(BrowserType browserType)
    {
        String selectedDriver;
        switch (browserType)
        {
            case FIREFOX :
                selectedDriver = firefoxDriverPath;
                break;
            default:
                selectedDriver = chromeDriverPath;
        }


        String osName ;

        if (System.getProperty("os.name").contains("win"))
            osName = "windows";
        else if (System.getProperty("os.name").contains("mac"))
            osName = "mac";
        else
            osName ="linux";


        String driverFileName = PropertyLoader.getInstance().getProperty("driver."+ browserType.getBrowserName()+"."+osName);
        String driverPath = driversBasePath  +"/"+ driverFileName;


        return driverPath;

    }

    public static void initDrivers ()
    {

        System.setProperty("webdriver.chrome.driver",getDriverPath(BrowserType.CHROME));
        System.setProperty("webdriver.gecko.driver",getDriverPath(FIREFOX));


    }

    public static WebDriver loadDriver()
    {


        initDrivers();

        switch (browserType.getBrowserName())
        {

            case "firefox":
            {
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                driver = new FirefoxDriver(capabilities);

            }

            default:
            {

                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                driver =  new ChromeDriver(capabilities);
            }

        }

        return driver;
    }

    public static WebDriver getDriver()
    {
        if (driver == null)
            return loadDriver();
        return driver;
    }


}
