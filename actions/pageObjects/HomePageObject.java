package pageObjects;

import commons.BasePage3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage3 {
    private WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }



    public void clickToRegisterLink() {

        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToELement(driver,HomePageUI.REGISTER_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToELement(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

}
