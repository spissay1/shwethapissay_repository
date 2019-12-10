import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import suite.SuiteManager;
import util.DriverManager;

import java.text.SimpleDateFormat;
import java.util.List;

public class LoginTestngSample extends SuiteManager {

    @Test
    public void Login() {

        DriverManager.driver.findElement(By.id("link-to-login")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys("shwethapissay@gmail.com");
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys("pass123");
        DriverManager.driver.findElement(By.name("commit")).click();

        List<WebElement> loginSuccesslist = DriverManager.driver.findElements(By.xpath("//*[contains(text(),'Logged in successfully')]"));
        if (loginSuccesslist.size() > 0) {
            System.out.println("Welcome message test shown successfully :: " + loginSuccesslist.get(0).getText());
        }
        else {
            System.out.println("Login not successful");
        }
    }
}
