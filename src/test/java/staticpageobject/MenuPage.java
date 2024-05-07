package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage {

    public static void clickHomePage(WebDriver driver) {
        driver.findElement(Locators.getLocator("MenuPage.homeMenuItemSelector")).click();
    }

    public static String getTitleHomePage(WebDriver driver) {
        return driver.getTitle();
    }

    public static void findRubberDucksMenuItem(WebDriver driver) {
        driver.findElement(Locators.getLocator("MenuPage.rubberDucksMenuItemSelector"));
    }
    public static void clickRubberDucksMenuItem(WebDriver driver) {
        driver.findElement(Locators.getLocator("MenuPage.rubberDucksMenuItemSelector")).click();
    }

    public static void findSubCategoryMenuItem(WebDriver driver) {
        driver.findElement(Locators.getLocator("MenuPage.subcategoryMenuItemSelector"));
    }

    public static void clickSubCategoryMenuItem(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Locators.getLocator("MenuPage.rubberDucksMenuItemSelector"))).moveToElement(driver.findElement(Locators.getLocator("MenuPage.subcategoryMenuItemSelector"))).click().build().perform();
    }

    public static String getProductQuantityInCart(WebDriver driver, int quantity) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.textToBe(Locators.getLocator("MenuPage.productQuantityInCart"), String.valueOf(quantity)));

        return driver.findElement(Locators.getLocator("MenuPage.productQuantityInCart")).getText();
    }
}
