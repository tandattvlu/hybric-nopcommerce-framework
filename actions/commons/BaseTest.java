package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    protected WebDriver  getBrowserDriver(String browserName){

        switch (browserName) {
            case "firefox":
                // cách này ko cần new nhưng cần version tương tứng
                driver = WebDriverManager.firefoxdriver().create();;
                break;

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser name is not valid.");

        }

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }


    protected int generateRandom(){
        return new Random().nextInt(99999);
    }
}
