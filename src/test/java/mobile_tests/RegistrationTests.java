package mobile_tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("cat12345@gmail.com")
                .password("Password123!")
                .firstName("Cat123")
                .lastName("Cats")
                .build();
        new SplashScreen(driver).goToSearchScreen(7);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(searchScreen.validatePopUpMessageRegistrationSucccess("Registration success!"));
    }
 @Test
 public void registrationNegativeTest(){
     int i = new Random().nextInt(1000);
     RegistrationBodyDto user = RegistrationBodyDto.builder()
             .username("cat12345@gmail.com")
             .password("Password123!")
             .firstName("Cat123")
             .lastName("Cats")
             .build();
     new SplashScreen(driver).goToSearchScreen(7);
     SearchScreen searchScreen = new SearchScreen(driver);
     searchScreen.clickBtnDots();
     searchScreen.clickBtnRegistration();
     RegistrationScreen registrationScreen = new RegistrationScreen(driver);
     registrationScreen.typeRegistrationForm(user);
     registrationScreen.clickBtnYalla();}
}
