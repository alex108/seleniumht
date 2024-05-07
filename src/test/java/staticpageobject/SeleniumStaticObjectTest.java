package staticpageobject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumStaticObjectTest extends TestBase{

    @Test
    public void homePageIsDisplayed() {

        MenuPage.clickHomePage(driver);

        String expectedTitlePage = "Online Store | My Store";

        Assert.assertEquals(MenuPage.getTitleHomePage(driver), expectedTitlePage);

    }

    @Test
    public void rubberDucksPageIsDisplayed() {

        MenuPage.clickRubberDucksMenuItem(driver);

        String expectedCategoryName = "Rubber Ducks";

        Assert.assertEquals(RubberDucksPage.getName(driver), expectedCategoryName);

    }

    @Test
    public void subcategoryPageIsDisplayed() {

        MenuPage.findRubberDucksMenuItem(driver);
        MenuPage.findSubCategoryMenuItem(driver);
        MenuPage.clickSubCategoryMenuItem(driver);

        String expectedCategoryName = "Subcategory";

        Assert.assertEquals(SubcategoryPage.getName(driver), expectedCategoryName);

    }

    @Test
    public void messageOfCorrectLogin(){

        LoginPage.attemptLogin(driver,"msshanti2017@gmail.com", "123456");

        String expectedSuccessTextLogin = "You are now logged in as Alex Tish.";

        Assert.assertEquals(HomePage.getSuccessMessageText(driver), expectedSuccessTextLogin);

    }

    @Test
    public void changeOfStateInEditAccount() {

        LoginPage.attemptLogin(driver,"msshanti2017@gmail.com", "123456");

        LoginPage.clickOnEditAccount(driver);

        EditAccountPage.selectZoneCodeFlorida(driver);
        EditAccountPage.clickSaveButton(driver);

        String expectedSelectedState = "Florida";

        Assert.assertEquals(EditAccountPage.getNameSelectedZoneFlorida(driver), expectedSelectedState);

    }

    @Test
    public void messageChangesSavedEditAccount() {

        LoginPage.attemptLogin(driver,"msshanti2017@gmail.com", "123456");

        LoginPage.clickOnEditAccount(driver);

        EditAccountPage.selectZoneCodeFlorida(driver);
        EditAccountPage.clickSaveButton(driver);

        String expectedSuccessEdit = "Changes saved";

        Assert.assertEquals(EditAccountPage.getSuccessMessageOnEditAccountPageText(driver), expectedSuccessEdit);

    }

    @Test
    public void incorrectPassword(){

        LoginPage.attemptLogin(driver,"msshanti2017@gmail.com", "12345678");

        String expectedErrorTextLoginOrPassword = "Wrong password or the account is disabled, or does not exist";

        Assert.assertEquals(HomePage.getErrorMessageText(driver), expectedErrorTextLoginOrPassword);

    }

    @Test
    public void userLogout(){

        LoginPage.attemptLogin(driver,"msshanti2017@gmail.com", "123456");

        LoginPage.clickOnLogout(driver);

        String expectedSuccessTextLogout = "You are now logged out.";

        Assert.assertEquals(HomePage.getSuccessMessageText(driver), expectedSuccessTextLogout);

    }

    @Test
    public void addPurpleDuckInCart() {

        CatalogPage.clickPurpleDuckSelectedProduct(driver);

        ProductDescriptionPage.addProductToCart(driver,4);

        Assert.assertEquals(MenuPage.getProductQuantityInCart(driver,4), "4");

    }

    @Test
    public void redDuckProductIsDisplayed() {

        CatalogPage.clickRedDuckSelectedProduct(driver);

        String expectedProductName = "Red Duck";

        Assert.assertEquals(ProductDescriptionPage.getTitleProduct(driver), expectedProductName);

    }

}
