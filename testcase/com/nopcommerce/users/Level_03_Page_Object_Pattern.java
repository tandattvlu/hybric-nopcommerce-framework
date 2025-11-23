package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_03_Page_Object_Pattern extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private RegisterPageObject registerPageObject;
    private LoginPageObject loginPageObject;
    private CustomerInfoPageObject customerInfoPageObject;

    private String firstName, lastName, emailAddress, companyName, password;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePageObject = new HomePageObject(driver);

        firstName = "Thomas";
        lastName = "A";
        emailAddress = "thomasA" + generateRandom() + "@gmail.de";
        companyName = "ABC";
        password = "123456789";
    }
    // Từ HomePage -> RegisterPage
    @Test
    public void User_01_Register(){
        // viết hàm giả
        // truyền data test ko phải locator
        // Action 1
        homePageObject.clickToRegisterLink();
        // Từ homepage qua register Page
        registerPageObject = new RegisterPageObject(driver);
        registerPageObject.clickToMaleRadio();
        registerPageObject.enterToFirstNameTextbox(firstName);
        registerPageObject.enterToLastNameTextbox(lastName);
        registerPageObject.enterToEmailTextbox(emailAddress);
        registerPageObject.enterToCompanyTextbox(companyName);
        registerPageObject.enterToPasswordTextbox(password);
        registerPageObject.enterToConfirmPasswordTextbox(password);
        registerPageObject.clickToRegisterButton();

        Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(),"Your registration completed");

    }
    // Từ Register -> Login
    @Test
    public void User_02_Login(){
        registerPageObject.clickToLoginLink();
        loginPageObject = new LoginPageObject(driver);

        loginPageObject.enterToEmailTextbox(emailAddress);
        loginPageObject.enterToPasswordTextbox(password);
        loginPageObject.clickToLoginButton();

    // Từ LoginPage -> HomePage
        homePageObject = new HomePageObject(driver);

        Assert.assertTrue(homePageObject.isMyAccountLinkDisplayed());


    }

    @Test
    public void User_03_MyAccount(){
    // Từ HomePage -> Customer Info Page
        homePageObject.clickToMyAccountLink();

        customerInfoPageObject = new CustomerInfoPageObject(driver);

        Assert.assertTrue(customerInfoPageObject.isGenderMaleSelected());

        Assert.assertEquals(customerInfoPageObject.getFirstNameTextboxValue(),firstName);

        Assert.assertEquals(customerInfoPageObject.getlastNameTextboxValue(),lastName);

        Assert.assertEquals(customerInfoPageObject.getEmailTextboxValue(),emailAddress);

        Assert.assertEquals(customerInfoPageObject.getCompanyTextboxValue(),companyName);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }


}


