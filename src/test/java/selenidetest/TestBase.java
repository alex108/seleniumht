package selenidetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeMethod
    protected void setup(){
        Configuration.baseUrl="https://litecart.stqa.ru/en/";
        open(Configuration.baseUrl);
        Configuration.browser="edge";
        Configuration.browserSize="1920x1080";
    }

    @AfterMethod
    protected void tearDown() {
        Selenide.closeWebDriver();
    }
}
