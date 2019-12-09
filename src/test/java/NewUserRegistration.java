import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.List;

public class NewUserRegistration {

    @Test
    public void verifyLogin() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.linkText("Create a new account")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("shwethapissay_"+timeStamp+"@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("pass123");
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("pass123");
        driver.findElement(By.name("commit")).click();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Welcome! You have signed up successfully.')]"));
        if(list.size() > 0){
            System.out.println("Pass :: Welcome message test shown successfully");
        }
        else{
            System.out.println("Fail :: Welcome message not shown");
        }

        driver.close();

    }
}
