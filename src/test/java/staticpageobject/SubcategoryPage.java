package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubcategoryPage extends PageBase{

    public static String getName(WebDriver driver) {
        return getName(driver, Locators.getLocator("SubCategoryPage.subcategoryNameSelector"));
    }
}
