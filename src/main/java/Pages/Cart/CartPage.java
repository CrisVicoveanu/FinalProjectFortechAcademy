package Pages.Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Pages.Cart.Locators.*;

public class CartPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = PRODUCTNAMELOCATOR)
    private List<WebElement> productNames;
    @FindBy(how = How.CSS, using = CARTPRODUCTQUANTITYLOCATOR)
    private WebElement cartQuantity;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isProductInCart(String productName) {
        By productLocator = By.cssSelector(PRODUCTNAMELOCATOR);
        List<WebElement> productElements = driver.findElements(productLocator);

        for (WebElement element : productElements) {
            if (element.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }
    public int checkCartQuantityCount(){
        return Integer.parseInt(driver.findElement(By.cssSelector("a > span.header_icon_btn_icon.header_v_align_m.mar_r4 > span")).getText());
    }
}