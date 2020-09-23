package config;

public enum BrowserType
{
    CHROME("chrome"),
    FIREFOX("firefox"),
    SAFARI("safari"),
    IE("ie");

    private String browserName;

    BrowserType(String browserName)
    {
        this.browserName = browserName;
    }

    public String getBrowserName()
    {
        return browserName;
    }
}
