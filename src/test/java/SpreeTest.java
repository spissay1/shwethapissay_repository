import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpreeTest {

    public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.linkText("Create a new account")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("shwethapissay@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("pass123");
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("pass123");
        driver.findElement(By.name("commit")).click();


    }

}
