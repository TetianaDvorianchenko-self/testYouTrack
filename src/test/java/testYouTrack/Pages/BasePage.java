package testYouTrack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
    public WebDriver driver;
    public static String baseUrl = "http://localhost:8080";
    protected String url;
    protected String pageUrl="";

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void visitPage() {
        url = baseUrl.concat(pageUrl);
        this.driver.get(url);
    }

    public void fillField(WebElement elem, String str){
        if (str!=null && !str.isEmpty())
            elem.sendKeys(str);
    }
}
