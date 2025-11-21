package com.nopcommerce.users;

import commons.BasePage3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_Base_Page_III_Inheritance extends BasePage3{
     WebDriver driver;


     String firstName, LastName, emailAddress, companyName, password;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        openPageUrl(driver,"https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        firstName = "Thomas";
        LastName = "A";
        emailAddress = "thomasA" + generateRandom() + "@gmail.de";
        companyName = "ABC";
        password = "123456789";

    }

    @Test
    public void TC_01_Register() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToELement(driver,"//a[@class='ico-register']");

        waitForElementClickable(driver,"//input[@id='gender-male']");
        clickToELement(driver,"//input[@id='gender-male']");

        sendKeyToElement(driver, "//input[@id='FirstName']",firstName);
        sendKeyToElement(driver, "//input[@id='LastName']",LastName);

        sendKeyToElement(driver, "//input[@id='Email']",emailAddress);
        sendKeyToElement(driver, "//input[@id='Company']",companyName);

        sendKeyToElement(driver, "//input[@id='Password']",password);
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']",password);

        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToELement(driver,"//button[@id='register-button']");


        Assert.assertEquals(getElementText(driver,"//div[@class='result']"),
                "Your registration completed");

        waitForElementClickable(driver,"//a[@class='ico-logout']");
        clickToELement(driver,"//a[@class='ico-logout']");

    }

    @Test
    public void TC_02_Login() {
        waitForElementClickable(driver,"//a[@class='ico-login']");
        clickToELement(driver,"//a[@class='ico-login']");

        sendKeyToElement(driver, "//input[@id='Email']",emailAddress);
        sendKeyToElement(driver, "//input[@id='Password']",password);

        waitForElementClickable(driver,"//button[@class='login-button']");
        clickToELement(driver,"//a[@class='ico-logout']");

        waitForElementClickable(driver,"//button[contains(@class,'login-button')]");
        clickToELement(driver,"//button[contains(@class,'login-button')]");


        Assert.assertTrue(isElementDisplayed(driver,"//a[@class='ico-account']"));
    }

    @Test
    public void TC_03_MyAccount() {
        waitForElementClickable(driver,"//a[@class='ico-account']");
        clickToELement(driver,"//a[@class='ico-account']");

        Assert.assertTrue(isElementSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='FirstName']","value"),firstName);
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='LastName']","value"),LastName);
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='Email']","value"),emailAddress);
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='Company']","value"),companyName);



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

   private int generateRandom(){
        return new Random().nextInt(99999);
   }
}


