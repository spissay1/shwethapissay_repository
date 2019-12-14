package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

public class HomePage extends SuiteManager {

    public HomePage(){

        PageFactory.initElements(DriverManager.driver, this);
    }
    @FindBy(id = "keywords")
    private WebElement searchKeyword;

    @FindBy(xpath = "//input[@type='submit' and @value='Search']")
    private WebElement searchButton;

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
