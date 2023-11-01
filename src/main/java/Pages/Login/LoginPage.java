package Pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static Pages.Login.Locators.*;
import static Pages.Util.Utils.waitASpecificAmountOfTime;

public class LoginPage {

    private WebDriver driver;
    @FindBy(how = How.CSS, using = EMAILINPUTFIELDLOCATOR)
    private WebElement emailInputField;
    @FindBy(how = How.CSS, using = PASSWORDINPUTFIELDLOCATOR)
    private WebElement passwordInputField;
    @FindBy(how = How.CSS, using = SUBMITBUTTONLOCATOR)
    private WebElement submitBtn;
    @FindBy(how = How.CSS, using = ERRORMESSAGEFIELDLOCATOR)
    private WebElement errorMessageField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeEmail (String email){emailInputField.sendKeys(email);}
    public void writePassword (String password){passwordInputField.sendKeys(password);}
    public void clickSubmitBtn (){submitBtn.click();}
    public void loginWithEmailAndPassword (String email, String password){
        writeEmail(email);
        writePassword(password);
        clickSubmitBtn();
    }
    public String returnLoginErrorMessage() {
        FluentWait wait = waitASpecificAmountOfTime(driver, 45, 500);

        if(wait.until(ExpectedConditions.visibilityOf(errorMessageField)) == null) {
            return "No error text found!";
        } else {
            return errorMessageField.getText();
        }
    }

}
