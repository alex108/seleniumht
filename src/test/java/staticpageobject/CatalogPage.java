package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

    public static void clickRedDuckSelectedProduct(WebDriver driver) {
        driver.findElement(Locators.getLocator("CatalogPage.redDuckMostPopularLocator")).click();

    }

    public static void clickPurpleDuckSelectedProduct(WebDriver driver) {
        driver.findElement(Locators.getLocator("CatalogPage.purpleDuckMostPopularLocator")).click();
    }
}
