import org.testng.Assert;
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

public class SearchMatchString extends SuiteManager {

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

    @Test(priority = 1)
    public void SearchMatchingItem(){
        String searchstr= config.getProperty("searchitem");
        basePage = new BasePage(DriverManager.driver);
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(this.username,this.password);
        searchPage = homePage.searchItem(searchstr);

        int listSize = searchPage.getProductsList().size();
        System.out.println("Products Total:: "+listSize);
            if(listSize>0){
                for(int i =0; i<listSize; i++){
                    String title = searchPage.getProductsList().get(i).getText();
                    System.out.println("Product Name ::"+ title);
                    Assert.assertTrue(title.toLowerCase().contains(searchstr.toLowerCase()));
                }
            }
            else{
                System.out.println("Search Title ::" +searchPage.getSearchTitle().getText());
                Assert.assertEquals("No products found",searchPage.getSearchTitle().getText());
            }
    }
}
