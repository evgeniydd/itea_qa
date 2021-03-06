package tests.ui;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.landing.MainPage;
import pages.signin.CreateAccountPage;

public class CreateAccountTest extends BaseTest{

    private MainPage mainPage;
    private CreateAccountPage createAccountPage;


    @BeforeTest
    public void initTest(){
        mainPage = new MainPage(driver);
    }

    @Test
    public void createAccountNegativeAllEmptyFieldsTest(){
        LOG.info("Test - can't create an account when all fields left empty");
        String name = "";
        String email = "";
        String password = "";
        String reenterPassword = "";

        mainPage.openSigninPage()
                .clickCreateAmazonAccount()
                .clickCreateYourAmazonAccount()
                .validateNameField(name)
                .validateEmailField(email)
                .validatePasswordField(password)
                .validateReenterPasswordField(reenterPassword);
    }

    @Test
    public void createAccountNegativeReenterPasswordEmptyTest(){
        LOG.info("Test - can't create an account when the fields are valid, except for Reenter field being empty");
        String name = "ValidName";
        String email = "validEmail@gmail.com";
        String password = "Qwerty_2020";
        String reenterPassword = "";
        mainPage.openSigninPage()
                .clickCreateAmazonAccount()
                .clickCreateYourAmazonAccount()
                .fillFieldsAndClickCreate(name,email,password,reenterPassword)
                .validateNameField(name)
                .validateEmailField(email)
                .validatePasswordField(password)
                .validateReenterPasswordField(reenterPassword);
    }
}
