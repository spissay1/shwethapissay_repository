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


    public List<WebElement> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<WebElement> productsList) {
        this.productsList = productsList;
    }

    public WebElement getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(WebElement searchTitle) {
        this.searchTitle = searchTitle;
    }
}
