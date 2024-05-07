package staticpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    protected final String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    protected void setup() {

        Browser browser = Browser.valueOf(System.getProperty("browser", "edge"));

        driver = switch (browser) {
            case chrome -> new ChromeDriver();
            case edge -> new EdgeDriver();
            case firefox -> new FirefoxDriver();
            //case safari -> new SafariDriver();
        };

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(baseUrl);

    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }
}
