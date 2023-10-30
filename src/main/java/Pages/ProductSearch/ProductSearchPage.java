package Pages.ProductSearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static Pages.ProductSearch.Locators.*;

public class ProductSearchPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = SEARCHQUERYINPUTFIELDLOCATOR)
    private WebElement searchQueryInputField;
    @FindBy(how = How.CSS, using = SEARCHBTNLOCATOR)
    private WebElement searchBtn;

    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        searchQueryInputField.sendKeys(productName);
        searchBtn.click();
    }
}

