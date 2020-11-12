package pages;

import config.PropertyLoader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @version 1.0-SNAPSHOT
 * Momi Back Office Home Page Object
 */


public class BoLoginPage
{
    WebDriver driver;
    private final long timeOutInSeconds = 7L;

    //************** Page components ************************//

    @FindBy(css = ".form-group:nth-child(1) > .form-control")
    WebElement loginField;
    @FindBy(css= ".form-group:nth-child(2) > .form-control")
    WebElement passwordField;
    @FindBy(css=".btn")
    WebElement loginButton;
    @FindBy(css=".help-block")
    WebElement loginFieldErrorMessage;
    @FindBy(css = ".form-group:nth-child(2) > .help-block")
    WebElement passwordFieldErrorMessage;

    @FindBy(css = ".toast-success")
    WebElement toastr;


    //*************** PropertyLoader call **********//

    PropertyLoader propertyLoader = PropertyLoader.getInstance();

    //*************** Constructor using page factory **********//
    public BoLoginPage(WebDriver driver)
    {
        this.driver = driver ;

        PageFactory.initElements(driver, this);
    }



    //*************** Bo HomePage Methods **********//

    public void  navigateToHomePage()
    { String homePageUrl  = propertyLoader.getProperty("base-url");
        driver.navigate().to(homePageUrl);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(loginField));


    }

    public void enterLogin (String login)
    {
        loginField.sendKeys(login);
    }

    public void enterPassword (String password)
    {
        passwordField.sendKeys(password);
    }

    public void enterCredentials (String login, String password)
    {
        enterLogin(login);
        enterPassword(password);
    }
    public void clickLoginButton ()
    {
        loginButton.click();
    }

    public String getLoginUrl()
    {
        return propertyLoader.getProperty("base-url");
    }


    public void login (String login, String password)
    {
        enterCredentials(login,password);
        loginButton.click();
    }

    public String getEmptyUsernameErrorMessage()
    {
        loginField.sendKeys(Keys.TAB);
        return loginFieldErrorMessage.getText();
    }

    public String getEmptyPasswordErrorMessage()
    {
        passwordField.sendKeys(Keys.TAB);
        return passwordFieldErrorMessage.getText();
    }

    public WebElement getToastr ()
    {
        return this.toastr;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public boolean toastrContains(String text)
    {
        return toastr.getText().contains(text);
    }




}
