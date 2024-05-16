package selenidetest;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductDescriptionPage {

    private static By titleProductSelector = By.tagName("h1");

    private static By inputQuantitySelector = By.cssSelector("input[name='quantity']");

    private static By addToCartButtonLocator = By.name("add_cart_product");


    public static void validateProductName(String expectedProductName) {
        $(titleProductSelector).shouldHave(text(expectedProductName));
    }

    public static void addProductToCart(int quantity) {
        $(inputQuantitySelector).clear();
        $(inputQuantitySelector).sendKeys(String.valueOf(quantity));
        $(addToCartButtonLocator).click();
    }
}
