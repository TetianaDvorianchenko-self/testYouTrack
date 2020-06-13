package testYouTrack.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public void setDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(2,TimeUnit.SECONDS);
        }
    }

}
