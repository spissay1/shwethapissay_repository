import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckoutSearchedItem {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("shwethapissay@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("pass123");
        driver.findElement(By.name("commit")).click();

        //Search by keyword for an item
        driver.findElement(By.id("keywords")).sendKeys("bag");
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
        //driver.findElement(By.xpath("(//submit[contains(text(),'Search')])[0]"));

        //WebElement secondElement = driver.findElement(By.cssSelector(".product-body-item:nth-child(2)"));

        //List<WebElement> productsList = driver.findElements(By.xpath("//*[contains(@class, 'product-body')]//a"));

        List<WebElement> productsList = driver.findElements(By.xpath("//*[@id='products']//a"));

        System.out.println("Products::"+productsList.size());

        if(productsList.size()>=2){
            String title =  productsList.get(1).getText();
            System.out.println("Product clicked :: " + title);
            String price = driver.findElements(By.xpath("//*[@id='products']//span[@class='price selling lead']")).get(1).getText();
            System.out.println("Product price :: " + price);
            productsList.get(1).click();
            driver.findElement(By.id("add-to-cart-button")).click();

            Thread.sleep(5000);
            String titleInCart=driver.findElement(By.xpath("//*[@id='cart-detail']//td[@class='cart-item-description']//a")).getText();
            System.out.println("Description of the item in the cart:: " + titleInCart);
            String priceInCart=driver.findElement(By.xpath("//*[@id='cart-detail']//td[contains(@class,'cart-item-price')]")).getText();
            System.out.println("Item price in cart is :"+priceInCart);

            if (title.equals(titleInCart)&& price.equals(priceInCart)){
                System.out.println("The item Name and price are matching");
                driver.findElement(By.id("checkout-link")).click();
                driver.findElement(By.xpath("//input[@type='submit' and @value='Save and Continue']")).click();
                driver.findElement(By.xpath("//input[@type='submit' and @value='Save and Continue']")).click();
                driver.findElement(By.xpath("//input[@name='order[payments_attributes][][payment_method_id]' and @value='3']")).click();
                driver.findElement(By.xpath("//input[@type='submit' and @value='Save and Continue']")).click();
                List<WebElement> orderSuccessText = driver.findElements(By.xpath("//*[contains(text(),'Your order has been processed successfully')]"));
                if(orderSuccessText.size()>0){
                    System.out.println("Order has been processed successfully");
                }
                else
                {
                    System.out.println("Order has NOT been placed");
                }
            }
            else{
                System.out.println("The item Name and price are NOT matching");
            }

        }

    }

}
