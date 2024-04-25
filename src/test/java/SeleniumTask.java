import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTask {

    @Test
    public void homePageIsDisplayed() {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement homePage = driver.findElement(By.cssSelector("#site-menu a[href='https://litecart.stqa.ru/en/']"));
        homePage.click();

        String expectedTitlePage = driver.getTitle();
        String actualTitlePage = "Online Store | My Store";

        Assert.assertEquals(actualTitlePage, expectedTitlePage);

        driver.quit();
    }

    @Test
    public void rubberDucksPageIsDisplayed() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberPage = driver.findElement(By.cssSelector("#site-menu a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        rubberPage.click();

        WebElement categoryName = driver.findElement(By.tagName("h1"));
        String actualCategoryName = categoryName.getText();
        String expectedCategoryName = "Rubber Ducks";

        Assert.assertEquals(actualCategoryName, expectedCategoryName);

        driver.quit();
    }

    @Test
    public void subcategoryPageIsDisplayed() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberPage = driver.findElement(By.cssSelector("#site-menu a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        WebElement subcategoryPage = driver.findElement(By.cssSelector("#site-menu a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/']"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberPage).build().perform();
        builder.moveToElement(subcategoryPage).click().build().perform();

        WebElement nameSubcategory = driver.findElement(By.tagName("h1"));
        String actualSubcategoryName = nameSubcategory.getText();
        String expectedCategoryName = "Subcategory";

        Assert.assertEquals(actualSubcategoryName, expectedCategoryName);

        driver.quit();

    }

    @Test
    public void messageOfCorrectLogin(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.sendKeys("msshanti2017@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456");

        WebElement loginSelector = driver.findElement(By.name("login"));
        loginSelector.click();

        String actualSuccessLogin = "You are now logged in as Alex Tish.";
        String expectedSuccessTextLogin = driver.findElement(By.cssSelector(".notice.success")).getText();

        Assert.assertEquals(actualSuccessLogin, expectedSuccessTextLogin);

        driver.quit();

    }

    @Test
    public void changeOfStateInAccount() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.sendKeys("msshanti2017@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456");

        WebElement loginSelector = driver.findElement(By.name("login"));
        loginSelector.click();

        WebElement editAccountSelector = driver.findElement(By.cssSelector("#box-account a[href='https://litecart.stqa.ru/en/edit_account']"));
        editAccountSelector.click();
        Select dropdown = new Select(driver.findElement(By.name("zone_code")));
        dropdown.selectByVisibleText("Florida");
        WebElement saveButtonSelector = driver.findElement(By.name("save"));
        saveButtonSelector.click();

        String actualSelectedState = driver.findElement(By.cssSelector("option[value='FL'][selected = 'selected']")).getText();
        String expectedSelectedState = "Florida";

        Assert.assertEquals(actualSelectedState, expectedSelectedState);

        driver.quit();

    }

    @Test
    public void messageChangesSavedEditAccount() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.sendKeys("msshanti2017@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456");

        WebElement loginSelector = driver.findElement(By.name("login"));
        loginSelector.click();

        WebElement editAccountSelector = driver.findElement(By.cssSelector("#box-account a[href='https://litecart.stqa.ru/en/edit_account']"));
        editAccountSelector.click();
        Select dropdown = new Select(driver.findElement(By.name("zone_code")));
        dropdown.selectByVisibleText("Florida");
        WebElement saveButtonSelector = driver.findElement(By.name("save"));
        saveButtonSelector.click();

        String actualSuccessEdit = "Changes saved";
        String expectedSuccessEdit = driver.findElement(By.cssSelector(".notice.success")).getText();

        Assert.assertEquals(actualSuccessEdit, expectedSuccessEdit);

        driver.quit();

    }

    @Test
    public void incorrectPassword(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.sendKeys("msshanti2017@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345678");

        WebElement loginSelector = driver.findElement(By.name("login"));
        loginSelector.click();

        String actualErrorTextLoginOrPassword = "Wrong password or the account is disabled, or does not exist";
        String expectedErrorTextLoginOrPassword = driver.findElement(By.cssSelector(".notice.errors")).getText();

        Assert.assertEquals(actualErrorTextLoginOrPassword, expectedErrorTextLoginOrPassword);

        driver.quit();

    }

    @Test
    public void userLogout(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.sendKeys("msshanti2017@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456");

        WebElement loginSelector = driver.findElement(By.name("login"));
        loginSelector.click();

        WebElement logoutSelector = driver.findElement(By.cssSelector("#box-account a[href='https://litecart.stqa.ru/en/logout']"));
        logoutSelector.click();

        String actualSuccessLogout = "You are now logged out.";
        String expectedSuccessTextLogout = driver.findElement(By.cssSelector(".notice.success")).getText();

        Assert.assertEquals(actualSuccessLogout, expectedSuccessTextLogout);

        driver.quit();

    }

    @Test
    public void addPurpleDuckInCart() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("#box-most-popular [alt='Purple Duck']")).click();
        driver.findElement(By.cssSelector("input[name='quantity']")).clear();
        driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys("4");
        driver.findElement(By.name("add_cart_product")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "4"));

        String quantityInCart = driver.findElement(By.cssSelector("span.quantity")).getText();

        Assert.assertEquals(quantityInCart, "4");

        driver.quit();
    }

    @Test
    public void redDuckProductIsDisplayed() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("#box-most-popular [alt='Red Duck']")).click();

        String expectedProductName = "Red Duck";
        String actualProductName = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualProductName, expectedProductName);

        driver.quit();

    }
}
