package selenidetest;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    private static By redDuckMostPopularLocator = By.cssSelector("#box-most-popular [alt='Red Duck']");
    private static By purpleDuckMostPopularLocator = By.cssSelector("#box-most-popular [alt='Purple Duck']");


    public static void clickRedDuckSelectedProduct() {
        $(redDuckMostPopularLocator).click();

    }

    public static void clickPurpleDuckSelectedProduct() {
        $(purpleDuckMostPopularLocator).click();
    }
}
