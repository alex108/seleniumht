package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDescriptionPage {

    public static String getTitleProduct(WebDriver driver) {
        return driver.findElement(Locators.getLocator("ProductDescriptionPage.titleProductSelector")).getText();
    }

    public static void addProductToCart(WebDriver driver, int quantity) {
        driver.findElement(Locators.getLocator("ProductDescriptionPage.inputQuantitySelector")).clear();
        driver.findElement(Locators.getLocator("ProductDescriptionPage.inputQuantitySelector")).sendKeys(String.valueOf(quantity));
        driver.findElement(Locators.getLocator("ProductDescriptionPage.addToCartButton")).click();
    }
}
