package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

import java.util.List;

public class HomePage extends SuiteManager {

    public HomePage(){

        PageFactory.initElements(DriverManager.driver, this);
    }
    @FindBy(id = "keywords")
    private WebElement searchKeyword;

    @FindBy(xpath = "//input[@type='submit' and @value='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='products']//a")
    private List<WebElement> productsList;

    @FindBy(xpath = "//*[@class='search-results-title']")
    private WebElement searchTitle;

    @FindBy(xpath = "//*[@id='products']//span[@class='price selling lead']")
    private WebElement productPrice;

    public WebElement getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(WebElement productPrice) {
        this.productPrice = productPrice;
    }

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

    public void enterValue(WebElement field, String value){
        field.click();
        field.clear();
        field.sendKeys(value);

    }

    public SearchPage searchItem(String searchitem){
            enterValue(searchKeyword,searchitem);
            searchButton.click();
            return new SearchPage();
    }
}
