package Purchase;

import Pages.Cart.CartPage;
import Pages.ProductResult.ProductResultPage;
import Pages.ProductSearch.ProductSearchPage;
import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {
    @Test(description = "User authenticates on site, searches for a product , adds the first result to the shopping cart and confirms adding the product to the cart.")
    public void testSearchAndAddFirstResultToCart(){
        driver.get(searchUrl);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.searchProduct("ulei");

        ProductResultPage productResultPage = new ProductResultPage(driver);
        productResultPage.waitForProductVisibility();
        productResultPage.addFirstProductToCart();
        String cartQuantityCounter = productResultPage.displayCartQuantityCount();
        boolean isCartQuantityCounterDisplayed = productResultPage.cartQuantityCounterIsDisplayed();

        CartPage cartPage = new CartPage(driver);
        driver.get(cartUrl);
        boolean expectedStatus = true;
        boolean actualStatus = cartPage.isProductInCart("Ulei Caprilis");
        int expectedCount = 1;
        int actualCount = cartPage.checkCartQuantityCount();

        Assert.assertTrue(isCartQuantityCounterDisplayed);
        Assert.assertEquals(actualStatus,expectedStatus);
        Assert.assertEquals(actualCount, expectedCount);
    }
}