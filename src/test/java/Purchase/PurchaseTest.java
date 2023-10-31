package Purchase;

import Pages.Login.LoginPage;
import Pages.ProductResult.ProductResultPage;
import Pages.ProductSearch.ProductSearchPage;
import Base.BaseTest;
import TestData.Search;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {
    @Test(description = "User search ulei and adds first result to shopping cart.", dataProvider = "searchQueries", dataProviderClass = BaseTest.class)
    public void testSearchAndAddFirstResultToCart(Search search) {
        LoginPage loginPage = new LoginPage(driver);
        ProductSearchPage searchPage = new ProductSearchPage(driver);
        ProductResultPage resultPage = new ProductResultPage(driver);

        String actualFirstProductAddedInCart = resultPage.addFirstProductToCart();
        String shoppingCart = actualFirstProductAddedInCart

        resultPage.waitForProductVisibility();
        resultPage.addFirstProductToCart();

        Assert.assertTrue(resultPage.cartQuantityCounterIsDisplayed());
        Assert.assertTrue();
        resultPage.confirmAddToCart();
        Assert.assertTrue(resultPage.isConfirmationMessageDisplayed());
    }

    }

