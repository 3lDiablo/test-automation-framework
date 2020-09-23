package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @version 1.0-SNAPSHOT
 * Momi Back Office Home Page Object
 */


public class BoHomePage
{
    //************** Page components ************************//

    @FindBy(css = "css=.form-group:nth-child(1) > .form-control")
    WebElement loginField;
    @FindBy(css= ".form-group:nth-child(2) > .form-control")
    WebElement passwordField;
    @FindBy(css=".btn")
    WebElement loginButton;
    @FindBy(css=".help-block")
    WebElement loginFieldErrorMessage;
    @FindBy(css = ".form-group:nth-child(2) > .help-block")
    WebElement passwordFieldErrorMessage;

    //*************** Constructor using page factory **********//
    public BoHomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void enterLogin (String login)
    {
        loginField.sendKeys(login);
    }

    public void enterPassword (String password)
    {
        loginField.sendKeys(password);
    }

    public void enterCredentials (String login, String password)
    {
        enterLogin(login);
        enterPassword(password);
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




}
