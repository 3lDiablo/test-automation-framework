package pages;


import config.PropertyLoader;
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
    WebDriver driver;
    private final long timeOutInSeconds = 7L;

    //************** Page components ************************//
    @FindBy(xpath = "//a[@id='dropdownAdmin']/div/span")
    WebElement profileMenu;
    @FindBy(css = ".d-flex > span")
    WebElement logOutButton;

    //*************** PropertyLoader call **********//

    PropertyLoader propertyLoader = PropertyLoader.getInstance();

    //*************** Constructor using page factory **********//
    public BoHomePage(WebDriver driver)
    {
        this.driver = driver ;

        PageFactory.initElements(driver, this);
    }

    public boolean checkUserEmail (String userEmail)
    {
        return profileMenu.getText().equals(userEmail);
    }
    public void clickOnUserProfileMenu()
    {
        profileMenu.click();
    }

    public void clickOnLogoutButton()
    {
        logOutButton.click();
    }

    //*************** Getters **********//


    public WebElement getProfileMenu() {
        return profileMenu;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }
}
