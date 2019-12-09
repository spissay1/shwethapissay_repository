import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class LoginTest {

    public static void main(String args[]) throws InterruptedException {
        validUserLogin();
        validUserWithRememberMeLogin();
        invalidUserIdLogin();
        invalidPasswordLogin();
        emptyUserLogin();
        emptyPasswordLogin();
        emptyUserAndPasswordLogin();
    }

    public static void validUserLogin() throws InterruptedException {
        System.out.println("Start of validUserLogin method");
        String userId = "shwethapissay@gmail.com";
        String password = "pass123";
        loginTest(userId, password, false);
        System.out.println("End of validUserLogin method");
    }

    public static void invalidUserIdLogin() throws InterruptedException {
        System.out.println("Start of invalidUserIdLogin method");
        String userId = "shwethapissay1@gmailcom";
        String password = "pass123";
        loginTest(userId, password, false);
        System.out.println("End of invalidUserIdLogin method");
    }

    public static void invalidPasswordLogin() throws InterruptedException {
        System.out.println("Start of invalidPasswordLogin method");
        String userId = "shwethapissay@gmail.com";
        String password = "pass";
        loginTest(userId, password, false);
        System.out.println("End of invalidPasswordLogin method");
    }

    public static void validUserWithRememberMeLogin() throws InterruptedException {
        System.out.println("Start of validUserWithRememberMeLogin method");
        String userId = "shwethapissay@gmail.com";
        String password = "pass123";
        loginTest(userId, password, true);
        System.out.println("End of validUserWithRememberMeLogin method");
    }

    public static void emptyUserLogin() throws InterruptedException {
        System.out.println("Start of emptyUserLogin method");
        String userId = "";
        String password = "pass123";
        loginTest(userId, password, false);
        System.out.println("End of emptyUserLogin method");
    }

    public static void emptyPasswordLogin() throws InterruptedException {
        System.out.println("Start of emptyPasswordLogin method");
        String userId = "shwethapissay@gmail.com";
        String password = "";
        loginTest(userId, password, false);
        System.out.println("End of emptyPasswordLogin method");
    }

    public static void emptyUserAndPasswordLogin() throws InterruptedException {
        System.out.println("Start of emptyUserAndPasswordLogin method");
        String userId = "";
        String password = "";
        loginTest(userId, password, false);
        System.out.println("End of emptyUserAndPasswordLogin method");
    }

    public static void loginTest(String userId, String password, boolean rememberMe) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("user-data-dir=/Users/techops/Downloads/temp/");
        capabilities.setCapability("chrome.binary", "c/chromedriver");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);

        System.out.println("Inside Existing User Registration Test");
        //System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver");
        //WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(userId);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        if (rememberMe) {
            driver.findElement(By.id("spree_user_remember_me")).click();
        }
        driver.findElement(By.name("commit")).click();

        List<WebElement> loginSuccesslist = driver.findElements(By.xpath("//*[contains(text(),'Logged in successfully')]"));
        if (loginSuccesslist.size() > 0) {
            System.out.println("Welcome message test shown successfully :: " + loginSuccesslist.get(0).getText());
            if (rememberMe) {
                driver.close();
                driver = new ChromeDriver(capabilities);
                System.out.println("Logging in second time");
                driver.get("https://spree-vapasi-prod.herokuapp.com");
                driver.manage().window().maximize();
                driver.findElement(By.linkText("Logout")).click();
                driver.close();

            } else {
                System.out.println("Inside Else");
                Thread.sleep(500);
                driver.findElement(By.linkText("Logout")).click();
                driver.close();
            }

        } else {
            System.out.println("Login Not Successful");
            List<WebElement> loginFaillist = driver.findElements(By.xpath("//*[contains(text(),'Invalid email or password')]"));
            //Boolean isErrorExists = driver.findElement(By.id("errorExplanation")).findElement(By.xpath("//*[text()='Invalid email or password']")).isDisplayed();
            if (loginFaillist.size() > 0) {
                System.out.println("Error successfully shown :: " + loginFaillist.get(0).getText());
            } else {
                System.out.println("Error is not shown");
            }
            driver.close();
        }
        Thread.sleep(500);
        driver.quit();
    }

}

