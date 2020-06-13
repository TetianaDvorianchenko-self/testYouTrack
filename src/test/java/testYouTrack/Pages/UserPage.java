package testYouTrack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserPage extends BasePage {
    String pageUrl = "/users/";
    @FindBy(id = "id_l.U.createNewUser")
    private WebElement createUserLink;

    @FindBy(className = "id_l.U.usersList.usersList")
    private WebElement userList;

    @FindAll(@FindBy(xpath = "//*[@id='id_l.U.usersList.usersList']/table/tbody/tr"))
    private List<WebElement> usersRow;

    public UserPage(String userLogin, WebDriver driver) {
        super(driver);
        pageUrl=this.pageUrl.concat(userLogin);
        url = baseUrl.concat(pageUrl);
        PageFactory.initElements(this.driver, this);
    }
    public boolean isPageShown(){
        return driver.getCurrentUrl().matches(url);
    }
}
