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
    @FindBy(how = How.CSS, using = PRODUCTNAME)
    private List<WebElement> productName;
    @FindBy(how = How.CSS, using = PRODUCTVARIANTLISTLOCATOR)
    private List<WebElement> productVariantList;
    @FindBy(how = How.CSS, using = QANTITYDOWNBTNLOCATOR)
    private List<WebElement> quantityDownBtn;
    @FindBy(how = How.CSS, using = QUICKBUYQUANTITYINPUTFIELDLOCATOR)
    private List<WebElement> quickBuyQuantityInputField;
    @FindBy(how = How.CSS, using = QUANTITYUPBTNLOCATOR)
    private List<WebElement> quantityUpBtn;
    @FindBy(how = How.CSS, using = ADDTOCARTBTNLOCATOR)
    private List<WebElement> addToCartBtn;
    @FindBy(how = How.CSS, using = CARTQUANTITYCOUNTERLOCATOR)
    private WebElement cartQuantityCounter;

    public ProductResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForProductVisibility(){
        FluentWait<WebDriver> wait = Utils.waitASpecificAmountOfTime(driver, 10, 500);
        wait.until(ExpectedConditions.visibilityOfAllElements(productName));
    }
    public void addFirstProductToCart(){
        if(!productName.isEmpty()){
            addToCartBtn.get(0).click();
        } else {
            throw new IllegalStateException("Momentan nu sunt produse in aceasta categorie");
        }
    }
    public String displayCartQuantityCount() {return cartQuantityCounter.getText();}
    public boolean cartQuantityCounterIsDisplayed() {return cartQuantityCounter.isDisplayed();}
}


