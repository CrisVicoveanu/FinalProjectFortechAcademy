package Pages.ProductResult;

import Pages.Util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

import static Pages.ProductResult.Locators.*;

public class ProductResultPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = PRODUCTNAMELOCATOR)
    private List<WebElement> productNameList;
    @FindBy(how = How.CSS, using = QUANTITYINPUTFIELDLOCATOR)
    private WebElement quantityInputField;
    @FindBy(how = How.CSS, using = ADDTOCARTBTNLOCATOR)
    private List<WebElement> addToCartBtn;
    @FindBy(how = How.CSS, using = CARTCOUNTERLOCATOR)
    private WebElement cartQuantityCounter;

    public ProductResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForProductVisibility(){
        FluentWait<WebDriver> wait = Utils.waitASpecificAmountOfTime(driver, 10, 500);
        wait.until(ExpectedConditions.visibilityOfAllElements(productNameList));
    }
    public void addFirstProductToCart(){
        if(!productNameList.isEmpty()){
            addToCartBtn.get(0).click();
        } else {
            throw new IllegalStateException("Momentan nu sunt produse in aceasta categorie");
        }
    }
    public String displayCartQuantityCount() {return cartQuantityCounter.getText();}
    public boolean cartQuantityCounterIsDisplayed() {return cartQuantityCounter.isDisplayed();}
}


