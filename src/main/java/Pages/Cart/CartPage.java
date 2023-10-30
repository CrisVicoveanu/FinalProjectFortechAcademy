package Pages.Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isProductInCart (String productName){
        return driver.findElement(By.linkText(productName)).isDisplayed();
    }
    public int checkCartQuantityCount(){
        return Integer.parseInt(driver.findElement(By.cssSelector("a > span.header_icon_btn_icon.header_v_align_m.mar_r4 > span")).getText());
    }
}
