package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public static void attemptLogin(WebDriver driver, String username, String password) {
        driver.findElement(Locators.getLocator("LoginPage.loginInput")).sendKeys(username);
        driver.findElement(Locators.getLocator("LoginPage.passwordInput")).sendKeys(password);
        driver.findElement(Locators.getLocator("LoginPage.loginButton")).click();
    }

    public static void clickOnLogout(WebDriver driver){
        driver.findElement(Locators.getLocator("LoginPage.logoutLink")).click();
    }

    public static void clickOnEditAccount(WebDriver driver){
        driver.findElement(Locators.getLocator("LoginPage.editAccountLink")).click();
    }

}
