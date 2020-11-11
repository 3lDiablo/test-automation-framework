package stepDefs;

import config.WebDriverManager;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etqu;
import io.cucumber.java.fr.Lorsqu;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BoHomePage;
import pages.BoLoginPage;


public class LogOutStepDefs
{

    private WebDriver driver = WebDriverManager.getDriver();
    BoHomePage boHomePage = new BoHomePage(driver);
    BoLoginPage boLoginPage = new BoLoginPage(driver);

//    public LogOutStepDefs() {
//        Lorsqu("^un administrateur clique sur le menu de l'utilisateur$", () -> {
//        });
//        Etqu("^il clique sur le bouton Déconnexion$", () -> {
//        });
//        Alors("^il se déconnecte et est renvoyé sur la page d'authentification$", () -> {
//        });
//    }

    @Lorsqu("un administrateur clique sur le menu de l'utilisateur")
    public void unAdministrateurCliqueSurLeMenuDeLUtilisateur()
    {
        WebDriverWait menuWait = new WebDriverWait(driver,7);
        menuWait.until(ExpectedConditions.visibilityOf(boHomePage.getProfileMenu()));
        //Assert.assertTrue(boHomePage.checkUserEmail("admin@momi.fr"));
        boHomePage.clickOnUserProfileMenu();
    }

    @Etqu("il clique sur le bouton Déconnexion")
    public void ilCliqueSurLeBoutonDéconnexion()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver,7);
        webDriverWait.until(ExpectedConditions.visibilityOf(boHomePage.getLogOutButton()));
        boHomePage.clickOnLogoutButton();

    }

    @Alors("il se déconnecte et est renvoyé sur la page d'authentification")
    public void ilSeDéconnecteEtEstRenvoyéSurLaPageDAuthentification()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver,7);
        webDriverWait.until(ExpectedConditions.visibilityOf(boLoginPage.getLoginField()));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(boLoginPage.getLoginUrl(), currentUrl);
    }
}
