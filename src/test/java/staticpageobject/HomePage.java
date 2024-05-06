package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public static String getErrorMessageText(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.errorMessageLocator")).getText();
    }

    public static String getSuccessMessageText(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.successMessageLocator")).getText();
    }
}
