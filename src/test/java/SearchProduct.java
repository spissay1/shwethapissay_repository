import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

import java.text.SimpleDateFormat;
import java.util.List;

public class SearchProduct extends SuiteManager{

    private static ConfigFileReader config = new ConfigFileReader();
    String searchItem;

    @BeforeTest
    public void enterSearchItem() {
        searchItem = config.getProperty("searchitem");
    }

    @Test
    public void searchProduct() {
        /*DriverManager.driver.findElement(By.id("link-to-login")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys("shwethapissay@gmail.com");
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys("pass123");
        DriverManager.driver.findElement(By.name("commit")).click();*/

        //Search by keyword for an item
        DriverManager.driver.findElement(By.id("keywords")).sendKeys(searchItem);
        DriverManager.driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
    }

}
