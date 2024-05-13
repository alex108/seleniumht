package selenidetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SeleniumSelenideTest extends TestBase{

    @Test
    public void homePageIsDisplayed() {

        MenuPage.clickHomePage();
        String expectedTitle = "Online Store | My Store";
        //Assert.assertEquals(title(), expectedTitle);
        Assert.assertEquals(MenuPage.getTitleHomePage(), expectedTitle);

    }

    @Test
    public void rubberDucksPageIsDisplayed() {

        MenuPage.clickRubberDucksMenuItem();
        String expectedCategoryName = "Rubber Ducks";
        RubberDucksPage.validateName(expectedCategoryName);

    }

    @Test
    public void subcategoryPageIsDisplayed() {

        MenuPage.clickSubCategoryMenuItem();
        String expectedCategoryName = "Subcategory";
        SubcategoryPage.validateName(expectedCategoryName);

    }

    @Test
    public void messageOfCorrectLogin(){

        LoginPage.attemptLogin("msshanti2017@gmail.com", "123456");
        String expectedSuccessTextLogin = "You are now logged in as Alex Tish.";
        HomePage.validateSuccessMessageText(expectedSuccessTextLogin);

    }

    @Test
    public void changeOfStateInEditAccount() {

        LoginPage.attemptLogin("msshanti2017@gmail.com", "123456");
        LoginPage.clickOnEditAccount();
        EditAccountPage.selectZoneCodeFlorida();
        EditAccountPage.clickSaveButton();
        String expectedSelectedState = "Florida";
        EditAccountPage.validateSelectedState(expectedSelectedState);

    }

    @Test
    public void messageChangesSavedEditAccount() {

        LoginPage.attemptLogin("msshanti2017@gmail.com", "123456");
        LoginPage.clickOnEditAccount();
        EditAccountPage.selectZoneCodeFlorida();
        EditAccountPage.clickSaveButton();
        String expectedSuccessEdit = "Changes saved";
        EditAccountPage.validateSuccessMessageOnEditAccountPage(expectedSuccessEdit);

    }

    @Test
    public void incorrectPassword(){

        LoginPage.attemptLogin("msshanti2017@gmail.com", "12345678");
        String expectedErrorTextLoginOrPassword = "Wrong password or the account is disabled, or does not exist";
        HomePage.validateErrorMessageText(expectedErrorTextLoginOrPassword);

    }

    @Test
    public void userLogout(){

        LoginPage.attemptLogin("msshanti2017@gmail.com", "123456");
        LoginPage.clickOnLogout();
        String expectedSuccessTextLogout = "You are now logged out.";
        HomePage.validateSuccessMessageText(expectedSuccessTextLogout);

    }

    @Test
    public void addPurpleDuckInCart() {

        CatalogPage.clickPurpleDuckSelectedProduct();
        ProductDescriptionPage.addProductToCart(4);
        MenuPage.validateProductQuantity(4);

    }

    @Test
    public void redDuckProductIsDisplayed() {

        CatalogPage.clickRedDuckSelectedProduct();
        String expectedProductName = "Red Duck";
        ProductDescriptionPage.validateProductName(expectedProductName);

    }
}
