package Pages.Cart;

import Pages.ProductResult.ProductResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Pages.Cart.Locators.PRODUCTNAMELOCATOR;
import static Pages.Cart.Locators.CARTPRODUCTQUANTITYLOCATOR;

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
        for (WebElement element : productNames) {
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
