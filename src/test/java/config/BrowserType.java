package config;

import java.util.Arrays;

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

    public static BrowserType getEnum(String browserName)
    {
        for(BrowserType v : values())
            if(v.getBrowserName().equalsIgnoreCase(browserName)) return v;
        throw new IllegalArgumentException("Unknown enum type " + browserName + ", Allowed values are " + Arrays.toString(values()));
    }
}
