package selenidetest;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static By emailInputLocator = By.name("email");

    private static By passwordInputLocator = By.name("password");

    private static By loginButtonLocator = By.name("login");

    private static By logoutLocator = By.cssSelector("#box-account a[href='https://litecart.stqa.ru/en/logout']");

    private static By editAccountLocator = By.cssSelector("#box-account a[href='https://litecart.stqa.ru/en/edit_account']");

    public static void attemptLogin(String username, String password) {
        $(emailInputLocator).sendKeys(username);
        $(passwordInputLocator).sendKeys(password);
        $(loginButtonLocator).click();
    }

    public static void clickOnLogout(){
        $(logoutLocator).click();
    }

    public static void clickOnEditAccount(){
        $(editAccountLocator).click();
    }
}
