package selenidetest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class EditAccountPage {

    private static By saveButtonSelector = By.name("save");

    private static By zoneDropdownSelector = By.name("zone_code");

    private static By selectedZoneFloridaSelector = By.cssSelector("option[value='FL'][selected = 'selected']");

    private static By successMessageEditAccountSelector = By.cssSelector(".notice.success");

    public static void clickSaveButton() {
        $(saveButtonSelector).click();
    }

    public static void selectZoneCodeFlorida() {
        Select dropdown = new Select($(zoneDropdownSelector));
        dropdown.selectByVisibleText("Florida");
    }


    public static void validateSelectedState(String expectedSelectedState) {
        $(selectedZoneFloridaSelector).shouldHave(text(expectedSelectedState));
    }

    public static void validateSuccessMessageOnEditAccountPage(String expectedSuccessEdit) {
        $(successMessageEditAccountSelector).shouldHave(text(expectedSuccessEdit));
    }
}
