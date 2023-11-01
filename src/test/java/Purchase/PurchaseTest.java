package Purchase;

import Pages.Login.LoginPage;
import Pages.ProductResult.ProductResultPage;
import Pages.ProductSearch.ProductSearchPage;
import Base.BaseTest;
import TestData.Purchase;
import TestData.Search;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {
    @Test(description = "User autentificates on site, search a product and adds first result to shopping cart.", dataProvider = "searchQueriesFirstResult", dataProviderClass = BaseTest.class)
    public void testSearchAndAddFirstResultToCart(Purchase firstProductName){

        Search search = new Search(searchResult.getName(testSearch(Search )));
        String getSearchFirstResult;
    }
}


