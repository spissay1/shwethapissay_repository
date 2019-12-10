package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suite.SuiteManager;
import util.DriverManager;

public class BasePage extends SuiteManager {

    public BasePage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#link-to-login")
    private WebElement loginButton;

    public LoginPage clickLoginButton(){
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginPage();
    }

}
