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

public class Level_02_Base_Page_II_StaticMethod {
    private WebDriver driver;

    BasePage3 basePage;
    private String firstName, LastName, emailAddress, companyName, password;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage = BasePage3.getBasePage3();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        firstName = "Thomas";
        LastName = "A";
        emailAddress = "thomasA" + generateRandom() + "@gmail.de";
        companyName = "ABC";
        password = "123456789";

    }

    @Test
    public void TC_01_Register() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToELement(driver,"//a[@class='ico-register']");

        basePage.waitForElementClickable(driver,"//input[@id='gender-male']");
        basePage.clickToELement(driver,"//input[@id='gender-male']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']",firstName);
        basePage.sendKeyToElement(driver, "//input[@id='LastName']",LastName);

        basePage.sendKeyToElement(driver, "//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Company']",companyName);

        basePage.sendKeyToElement(driver, "//input[@id='Password']",password);
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']",password);

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToELement(driver,"//button[@id='register-button']");


        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"),
                "Your registration completed");

        basePage.waitForElementClickable(driver,"//a[@class='ico-logout']");
        basePage.clickToELement(driver,"//a[@class='ico-logout']");

    }

    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-login']");
        basePage.clickToELement(driver,"//a[@class='ico-login']");

        basePage.sendKeyToElement(driver, "//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Password']",password);

        basePage.waitForElementClickable(driver,"//button[@class='login-button']");
        basePage.clickToELement(driver,"//a[@class='ico-logout']");

        basePage.waitForElementClickable(driver,"//button[contains(@class,'login-button')]");
        basePage.clickToELement(driver,"//button[contains(@class,'login-button')]");


        Assert.assertTrue(basePage.isElementDisplayed(driver,"//a[@class='ico-account']"));
    }

    @Test
    public void TC_03_MyAccount() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-account']");
        basePage.clickToELement(driver,"//a[@class='ico-account']");

        Assert.assertTrue(basePage.isElementSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='FirstName']","value"),firstName);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='LastName']","value"),LastName);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='Email']","value"),emailAddress);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='Company']","value"),companyName);



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

   private int generateRandom(){
        return new Random().nextInt(99999);
   }
}


