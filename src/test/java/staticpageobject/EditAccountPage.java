package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {

    public static void clickSaveButton(WebDriver driver) {
        driver.findElement(Locators.getLocator("EditAccountPage.saveButtonSelector")).click();
    }

    public static void selectZoneCodeFlorida(WebDriver driver) {
        Select dropdown = new Select(driver.findElement(Locators.getLocator("EditAccountPage.zoneDropdownSelector")));
        dropdown.selectByVisibleText("Florida");
    }

    public static String getNameSelectedZoneFlorida(WebDriver driver) {
        return driver.findElement(Locators.getLocator("EditAccountPage.selectedZoneFloridaSelector")).getText();
    }

    public static String getSuccessMessageOnEditAccountPageText(WebDriver driver) {
        return driver.findElement(Locators.getLocator("EditAccountPage.successMessageEditAccountSelector")).getText();
    }
}
