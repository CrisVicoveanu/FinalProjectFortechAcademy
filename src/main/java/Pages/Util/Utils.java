package Pages.Util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Utils {
    public static FluentWait waitASpecificAmountOfTime(WebDriver driver, int totalWaitTime, int pollingTime) {
        return new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(totalWaitTime))
                .pollingEvery(Duration.ofMillis(pollingTime))
                .ignoring(NoSuchElementException.class);
    }

}
