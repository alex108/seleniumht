package selenidetest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PageBase {


    public static SelenideElement validateName(SelenideElement test, String expectedCategoryName) {
        return $(test).shouldHave(text(expectedCategoryName));
    }
}
