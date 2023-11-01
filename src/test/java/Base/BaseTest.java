package Base;

import Pages.Login.LoginPage;
import Pages.ProductSearch.ProductSearchPage;
import TestData.Purchase;
import TestData.Search;
import TestData.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import javax.naming.directory.SearchResult;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriver wait;
    public String baseUrl = "https://www.ellemental.ro/";
    public String loginUrl = "https://www.ellemental.ro/autentificare?back=my-account";
    private String searchUrl = "https://www.ellemental.ro/contul-meu";
    public String resultPageUrl = "https://www.ellemental.ro/cautare?controller=search&orderby=position&orderway=desc&ssa_submit=&search_query=";
    public String cartUrl = "https://www.ellemental.ro/cos?action=show";
    private LoginPage loginPage;
    private User user;
    public Search search;
    public SearchResult searchResult;

    @DataProvider(name = "searchQueriesFirstResult")
    public Object[][] provideSearchQueriesFirstResult(String searchQuery, String searchResult) {
        return new Object[][]{
                new Object[]{new Search[]{new Search("ulei", "Ulei Caprilis")}},
        };
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        final String driverChrome = "webdriver.chrome.driver";
        final String chromeDriverAddress = "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe";
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--no-sandbox");
        System.setProperty(driverChrome, chromeDriverAddress);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(loginUrl);
        driver.get(searchUrl);
        driver.get(resultPageUrl);
        driver.get(cartUrl);

        loginPage = new LoginPage(driver);
        user = new User("criss.vicoveanu@gmail.com", "TestFortech.1");
        loginPage.loginWithEmailAndPassword(user.getEmail(), user.getPassword());

    }



    @AfterMethod
    public void tearDown() {
        System.out.println("Tests are completed, webdriver is closing.");
        driver.quit();
    }

    }
