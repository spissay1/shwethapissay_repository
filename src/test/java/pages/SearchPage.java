package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import suite.SuiteManager;
import util.DriverManager;

import java.util.List;

public class SearchPage extends SuiteManager {

    public SearchPage(){

        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(xpath = "//*[@id='products']//a")
    private List<WebElement> productsList;

    @FindBy(xpath = "//*[@class='search-results-title']")
    private WebElement searchTitle;

    public void productMatchingSearchString(String searchitem){
           int listSize = productsList.size();
        System.out.println("Products Total:: "+listSize);
        if(listSize>0){
            for(int i =0; i<listSize; i++){
                String title =  productsList.get(i).getText();
                System.out.println("Product Name ::"+ title);
                Assert.assertTrue(title.toLowerCase().contains(searchitem.toLowerCase()));
            }

        }
        else{
            System.out.println("Search Title ::" +searchTitle.getText());
            Assert.assertEquals("No products found",searchTitle.getText());
        }

    }

}
