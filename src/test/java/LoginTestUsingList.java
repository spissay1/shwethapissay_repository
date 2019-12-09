import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

public class LoginTestUsingList {
    public static void main(String args[]) throws InterruptedException {
        LoginUser validUserRememberMe = new LoginUser("shwethapissay@gmail.com", "pass123", true);
        LoginUser validUser = new LoginUser("shwethapissay@gmail.com", "pass123", false);
        LoginUser validUserInvalidPassword = new LoginUser("shwethapissay@gmail.com", "3458973495", false);
        LoginUser invalidUser = new LoginUser("aaaaaa@aaaa.com", "pass123", false);
        LoginUser emptyUser = new LoginUser("", "pass123", false);
        LoginUser emptyPassword = new LoginUser("shwethapissay@gmail.com", "", false);
        LoginUser emptyUserAndPassword = new LoginUser("", "", false);
        //LoginUser valUser = new LoginUser("aaaaaa@aaaa.com","pass123",false);
        List<LoginUser> usersList = new ArrayList<LoginUser>();
        usersList.add(validUser);
        usersList.add(validUserRememberMe);
        usersList.add(validUserInvalidPassword);
        usersList.add(invalidUser);
        usersList.add(emptyUser);
        usersList.add(emptyPassword);
        usersList.add(emptyUserAndPassword);

        for (LoginUser user : usersList) {
            loginTest(user);
        }


    }

    private static void loginTest(LoginUser loginCredentials) throws InterruptedException {
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
        driver.findElement(By.id("spree_user_email")).sendKeys(loginCredentials.getUserId());
        driver.findElement(By.id("spree_user_password")).sendKeys(loginCredentials.getPassword());
        if (loginCredentials.getRememberMe()) {
            driver.findElement(By.id("spree_user_remember_me")).click();
        }
        driver.findElement(By.name("commit")).click();

        List<WebElement> loginSuccesslist = driver.findElements(By.xpath("//*[contains(text(),'Logged in successfully')]"));
        if (loginSuccesslist.size() > 0) {
            System.out.println("Welcome message test shown successfully :: " + loginSuccesslist.get(0).getText());
            if (loginCredentials.getRememberMe()) {
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
            }
            else {
                System.out.println("Error is not shown");
            }
            driver.close();
        }
        Thread.sleep(500);
        driver.quit();
    }

}

