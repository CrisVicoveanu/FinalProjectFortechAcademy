package Base;

import Pages.Login.LoginPage;
import TestData.Search;
import TestData.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public String loginUrl = "https://www.ellemental.ro/autentificare?back=my-account";
    public String searchUrl = "https://www.ellemental.ro/contul-meu";
    public String cartUrl = "https://www.ellemental.ro/cos?action=show";
    private LoginPage loginPage;
    private User user;

    @DataProvider(name = "searchQueriesFirstResult")
    public Object[][] provideSearchQueriesFirstResult() {
        return new Object[][]{
                {new Search("ulei", "Ulei Caprilis")}
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

        loginPage = new LoginPage(driver);
        user = new User("criss.vicoveanu@gmail.com", "TestFortech.1");
        loginPage.loginWithEmailAndPassword(user.getEmail(), user.getPassword());
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tests are completed, web-driver is closing.");
        driver.quit();
    }
}
