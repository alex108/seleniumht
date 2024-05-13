package selenidetest;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static By errorMessageLocator = By.cssSelector(".notice.errors");

    private static By successMessageLocator = By.cssSelector(".notice.success");


    public static void validateErrorMessageText(String expectedErrorTextLoginOrPassword) {
        $(errorMessageLocator).shouldHave(text(expectedErrorTextLoginOrPassword));
    }


    public static void validateSuccessMessageText(String expectedSuccessTextLogin) {
        $(successMessageLocator).shouldHave(text(expectedSuccessTextLogin));
    }
}
