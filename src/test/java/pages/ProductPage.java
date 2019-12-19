package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

import java.util.List;

public class ProductPage extends SuiteManager {

    public ProductPage(){

        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(id = "add-to-cart-button")
    private WebElement addtocartbtn;

    @FindBy(id = "quantity")
    private WebElement qtytextbox;

    public WebElement getAddtocartbtn() {
        return addtocartbtn;
    }

    public void setAddtocartbtn(WebElement addtocartbtn) {
        this.addtocartbtn = addtocartbtn;
    }

    public WebElement getQtytextbox() {
        return qtytextbox;
    }

    public void setQtytextbox(WebElement qtytextbox) {
        this.qtytextbox = qtytextbox;
    }

    public void enterValue(WebElement field, String value){
        field.click();
        field.clear();
        field.sendKeys(value);

    }

}
