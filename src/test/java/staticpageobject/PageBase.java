package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {

    protected static String getName(WebDriver driver, By test) {
        return driver.findElement(test).getText();
    }
}
