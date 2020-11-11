package stepDefs;

import config.WebDriverManager;
import io.cucumber.java.fr.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BoLoginPage;


public class boLoginSteps
{

    private WebDriver driver = WebDriverManager.getDriver();
    BoLoginPage boLoginPage =  new BoLoginPage(driver) ;

    @Etantdonné("Un administrateur ouvre la page d'acceuil du back office Momi")
    public void asAdminNavigateToLoginPage()
    {
        boLoginPage.navigateToHomePage();
    }

    @Lorsque("l'il saisie ses identifiants correctement")
    public void enterCorrectAdminCredentials()
    {
        boLoginPage.enterCredentials("admin@momi.fr","Azerty1!");
    }


    @Etqu("il clique sur le bouton SE CONNECTER")
    public void clickOnLoginButton()
    {
        boLoginPage.clickLoginButton();
    }

    @Alors("il accède au back office Momi et visualise la liste des membres Momi")
    public void accessToBoOnFreelancesTable()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver,7);
        webDriverWait.until(ExpectedConditions.visibilityOf(boLoginPage.getToastr()));
        Assert.assertTrue(boLoginPage.toastrContains("Authentification réussie"));
    }


}
