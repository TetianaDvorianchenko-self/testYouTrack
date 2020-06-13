package testYouTrack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testYouTrack.Util.User;

import java.util.List;

public class UsersPage extends BasePage {

    @FindBy(id = "id_l.U.createNewUser")
    private WebElement createUserLink;

    @FindBy(className = "id_l.U.usersList.usersList")
    private WebElement userList;

    @FindAll(@FindBy(xpath = "//*[@id='id_l.U.usersList.usersList']/table/tbody/tr"))
    private List<WebElement> usersRow;

    public UsersPage(WebDriver driver)
    {
        super(driver);
        pageUrl = "/users";
        visitPage();
        PageFactory.initElements(this.driver, this);
    }

    public WebElement findUserInList(User user) {
        for (WebElement userRow : usersRow) {
            UserListElement userElem = new UserListElement(this.driver, userRow);
            if (userElem.checkUserLogin(user.getLogin()))
            {
                return userRow;
            }
        }
        return null;
    }

    public UserListElement findUserInListByUserNameStart(String userName) {
        for (WebElement userRow : usersRow) {
            UserListElement userElem = new UserListElement(this.driver, userRow);
            if (userElem.checkUserLoginByStart(userName))
            {
                return userElem;
            }
        }
        return null;
    }

    public CreateUserPage addNewUser() {
        createUserLink.click();
        return new CreateUserPage(this.driver);
    }

    public boolean pageIsShown(){
        return this.createUserLink.isDisplayed();
    }
}