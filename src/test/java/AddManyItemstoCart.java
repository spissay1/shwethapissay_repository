import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

public class AddManyItemstoCart extends SuiteManager {

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
    public ProductPage productPage;

    @Test (priority = 2)
    public void addManyItems() {
        basePage = new BasePage(DriverManager.driver);
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(this.username, this.password);

        System.out.println("Products::" + homePage.getProductsList().size());

        if (homePage.getProductsList().size() > 0) {
            //Add product 1 and enter 5 in quantity text box
            homePage.getProductsList().get(1).click();
            String prodTitle1 = homePage.getProductsList().get(1).getText();
            productPage = new ProductPage();
            productPage.enterValue(productPage.getQtytextbox(),"5");
            productPage.getAddtocartbtn().click();

            // Add product 2 and increment the quantity by clicking the increment button
            homePage.getProductsList().get(2).click();
            productPage.;



        }
    }
}
