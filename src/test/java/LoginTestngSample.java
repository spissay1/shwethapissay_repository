
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

import java.text.SimpleDateFormat;
import java.util.List;

public class LoginTestngSample extends SuiteManager {
    /*private static ConfigFileReader config = new ConfigFileReader();
    String userName;
    String passWord;
    @BeforeTest
    public void enterUserIDPassword() {
        userName = config.getProperty("username");
        passWord = config.getProperty("password");
    }
*/
    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;

    @Test (dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void Login(String username, String password) {
        basePage = new BasePage(DriverManager.driver);
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(username, password);
        /*DriverManager.driver.findElement(By.id("link-to-login")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys(username);
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys(password);
        DriverManager.driver.findElement(By.name("commit")).click(); */

        List<WebElement> loginSuccesslist = DriverManager.driver.findElements(By.xpath("//*[contains(text(),'Logged in successfully')]"));
        if (loginSuccesslist.size() > 0) {
            System.out.println("Welcome message test shown successfully :: " + loginSuccesslist.get(0).getText());
        }
        else {
            System.out.println("Login not successful");
        }
    }
}
