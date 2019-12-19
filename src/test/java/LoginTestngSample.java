
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.List;

public class LoginTestngSample extends SuiteManager {
    private static ConfigFileReader config = new ConfigFileReader();
    String username;
    String password;

    @BeforeTest
    public void enterUserIDPassword() {
        this.username = config.getProperty("username");
        this.password = config.getProperty("password");
    }

    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;
    public SearchPage searchPage;

    @Test (priority = 0)
    public void Login() {
        basePage = new BasePage(DriverManager.driver);
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(this.username,this.password);

        List<WebElement> loginSuccesslist = DriverManager.driver.findElements(By.xpath("//*[contains(text(),'Logged in successfully')]"));
        if (loginSuccesslist.size() > 0) {
            System.out.println("Welcome message test shown successfully :: " + loginSuccesslist.get(0).getText());
            Assert.assertEquals("Logged in successfully",loginSuccesslist.get(0).getText());
        }
        else {
            System.out.println("Login not successful");
        }

    }


}
