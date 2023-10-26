package Pages.ProductSearch;

import Pages.Util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

import static Pages.ProductSearch.Locators.*;

public class ProductSearchPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = SEARCHQUERYINPUTFIELDLOCATOR)
    private WebElement searchQueryInputField;
    @FindBy(how = How.CSS, using = SEARCHBTNLOCATOR)
    private WebElement searchBtn;
    @FindBy(how = How.CSS, using = PRODUCTNAME)
    private List<WebElement> productName;
    @FindBy(how = How.CSS, using = DATAPRODUCTATTRIBUTEFIELDLOCATOR)
    private List<WebElement> dataProductAttributeField;
    @FindBy(how = How.CSS, using = QANTITYDOWNBTNLOCATOR)
    private List<WebElement> quantityDownBtn;
    @FindBy(how = How.CSS, using = QUICKBUYQUANTITYINPUTFIELDLOCATOR)
    private List<WebElement> quickBuyQuantityInputField;
    @FindBy(how = How.CSS, using = QUANTITYUPBTNLOCATOR)
    private List<WebElement> quantityUpBtn;
    @FindBy(how = How.CSS, using = ADDTOCARTBTNLOCATOR)
    private List<WebElement> addToCartBtn;
    @FindBy(how = How.CSS, using = CARTQUANTITYAMOUNTCOUNTERLOCATOR)
    private List<WebElement> cartQuantityAmountCounter;

    public ProductSearchPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void searchProduct (String productName){
        searchQueryInputField.sendKeys(productName);
        searchBtn.click();
    }

    public void waitForProductVisibility(){
        FluentWait<WebDriver> wait = Utils.waitASpecificAmountOfTime(driver, 10, 500);
        wait.until(ExpectedConditions.visibilityOfAllElements(productName));
    }
}
