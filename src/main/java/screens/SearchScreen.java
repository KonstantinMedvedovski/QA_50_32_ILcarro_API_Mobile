package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }
    @AndroidFindBy(xpath ="//android.widget.ImageView[@content-desc='More options']")
    WebElement btnDots;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.telran.ilcarro:id/title' and @text='Login']")
    WebElement btnLogin;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.telran.ilcarro:id/title' and @text='Registration']")
    WebElement btnRegistration;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Registration success!']")
    WebElement popUpMessageRegistrationSucccess;

    public void clickBtnDots(){
        clickWait(btnDots,3);
    }
    public void clickBtnLogin(){
        clickWait(btnLogin,3);
    }
    public void clickBtnRegistration(){
        clickWait(btnRegistration,3);
    }
    public boolean validatePopUpMessageRegistrationSucccess(String text){
        return isTextInElementPresent(popUpMessageRegistrationSucccess,text,5);
    }

}
