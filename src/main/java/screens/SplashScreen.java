package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class SplashScreen extends BaseScreen{
    public SplashScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.telran.ilcarro:id/versionText")
    WebElement versionApp;

    public boolean validateVersion() {
        return isTextInElementPresent(versionApp,
                "Version 1.0.0", 5);
    }

}
