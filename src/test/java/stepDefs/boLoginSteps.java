package stepDefs;

import config.WebDriverManager;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Etqu;
import io.cucumber.java.fr.Lorsque;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BoHomePage;

public class boLoginSteps
{

    private WebDriver driver = WebDriverManager.loadDriver();
    BoHomePage boHomePage =  new BoHomePage(driver) ;

    @Etantdonné("Un administrateur ouvre la page d'acceuil du back office Momi")
    public void asAdminNavigateToLoginPage()
    {
        boHomePage.navigateToHomePage();
    }

    @Lorsque("l'il saisie ses identifiants correctement")
    public void lIlSaisieSesIdentifiantsCorrectement()
    {
        boHomePage.enterCredentials("admin@momi.fr","Azerty1!");
    }


    @Etqu("il clique sur le bouton SE CONNECTER")
    public void ilCliqueSurLeBoutonSECONNECTER()
    {
        boHomePage.clickLoginButton();
    }

    @Alors("il accède au back office Momi et visualise la liste des membres Momi")
    public void ilAccèdeAuBackOfficeMomiEtVisualiseLaListeDesMembresMomi()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver,7);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".d-lg-block:nth-child(2)")));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://momi-bo-int.iaaucarre.net/freelance"));
    }
}
