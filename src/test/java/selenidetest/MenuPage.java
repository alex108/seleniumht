package selenidetest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class MenuPage {

    private static By homeMenuItemSelector = By.cssSelector("#site-menu a[href='https://litecart.stqa.ru/en/']");

    private static By rubberDucksMenuItemSelector = By.cssSelector("#site-menu a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");

    private static By subcategoryMenuItemSelector = By.cssSelector("#site-menu a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/']");

    private static By productQuantityInCart = By.cssSelector("span.quantity");

    public static void clickHomePage() {
        $(homeMenuItemSelector).click();
    }

    public static String getTitleHomePage() {
        return Selenide.title();
    }

    public static void clickRubberDucksMenuItem() {
        $(rubberDucksMenuItemSelector).click();
    }

    public static void clickSubCategoryMenuItem() {
        actions()
                .moveToElement($(rubberDucksMenuItemSelector))
                .moveToElement($(subcategoryMenuItemSelector))
                .click()
                .build()
                .perform();
    }

    public static void validateProductQuantity(int quantity) {
        $(productQuantityInCart).shouldHave(text(String.valueOf(quantity)));
    }
}
