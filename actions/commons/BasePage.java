package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
   // viết hàm chuẩn theo 5 nguyên tắc
    // xem ở phần common function ở framwork 2 trong word
   WebDriver driver;
    public void clickToElement(WebDriver driver) {
        driver.findElement(By.cssSelector("")).click();
    }

    public String getElementText(WebDriver driver){
        return driver.findElement(By.cssSelector("")).getText();
    }

    public void sendKeyToElement(String valueToSendkey){

        driver.findElement(By.cssSelector("")).sendKeys("ABC");
    }
}
