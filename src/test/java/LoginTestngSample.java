
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

import java.text.SimpleDateFormat;
import java.util.List;

public class LoginTestngSample extends SuiteManager {
    private static ConfigFileReader config = new ConfigFileReader();
    /*String userName;
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
    public SearchPage searchPage;

    @Test (dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void Login(String username, String password) {
        basePage = new BasePage(DriverManager.driver);
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(username, password);

        List<WebElement> loginSuccesslist = DriverManager.driver.findElements(By.xpath("//*[contains(text(),'Logged in successfully')]"));
        if (loginSuccesslist.size() > 0) {
            System.out.println("Welcome message test shown successfully :: " + loginSuccesslist.get(0).getText());
        }
        else {
            System.out.println("Login not successful");
        }
    }

    @Test (dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void SearchItem(String username, String password){
        String searchitem= config.getProperty("searchitem");
        basePage = new BasePage(DriverManager.driver);
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(username, password);
        searchPage = homePage.searchItem(searchitem);
        searchPage.productMatchingSearchString(searchitem);

    }
}
