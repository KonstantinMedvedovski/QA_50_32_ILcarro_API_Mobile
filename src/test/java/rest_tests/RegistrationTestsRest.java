package rest_tests;

import api_rest.AuthentificationController;
import dto.ErrorMessageDto;
import dto.RegistrationBodyDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class RegistrationTestsRest  extends AuthentificationController {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("cat"+ i + "@gmail.com")
                .password("Password123!")
                .firstName("Cat123")
                .lastName("Cats")
                .build();
        Assert.assertEquals(registrationLogin(user,REGISTRATION_URL)
                .getStatusCode(),200);
    }

    @Test
    public void registrationNegativeTest_WrongEmail() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("cat" + i + "gmail.com")
                .password("Password123!")
                .firstName("Cat123")
                .lastName("Cats")
                .build();
        Response response = registrationLogin(user,REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode()
                ,400,"validate status code");
        ErrorMessageDto errorMessageDto = response.getBody()
                .as(ErrorMessageDto.class);
        System.out.println(errorMessageDto);
        softAssert.assertEquals(errorMessageDto.getError()
                ,"Bad Request","validate error name");
        softAssert.assertTrue(errorMessageDto.getMessage().toString()
                .contains("must be a well-formed email address")
                ,"validate massage");
        softAssert.assertAll();
    }
}
