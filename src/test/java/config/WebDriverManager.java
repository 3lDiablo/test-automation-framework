package config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager
{
    private String driversBasePath = PropertyLoader.getInstance().getProperty("drivers");
    private String chromeDriverPath = PropertyLoader.getInstance().getProperty("driver.chrome ");
    private String firefoxDriverPath = PropertyLoader.getInstance().getProperty("driver.firefox");

    public  String getDriverPath(BrowserType browserType)
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
        return driversBasePath + selectedDriver + driverFileName;

    }

    public void intDrivers ()
    {
        System.setProperty("webdriver.chrome.driver",getDriverPath(BrowserType.CHROME));
        System.setProperty("webdriver.firefox.driver",getDriverPath(BrowserType.FIREFOX));

    }

    public WebDriver loadDriver(BrowserType browserType)
    {
        switch (browserType)
        {

            case FIREFOX:
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }
}
