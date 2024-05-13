package selenidetest;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SubcategoryPage extends PageBase {

    private static SelenideElement subcategoryNameSelector =  $(By.tagName("h1"));


    public static SelenideElement validateName(String expectedCategoryName) {

        return validateName(subcategoryNameSelector,expectedCategoryName);
    }

}
