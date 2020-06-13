package testYouTrack.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import testYouTrack.DataProvider.UserDataProvider;
import testYouTrack.Pages.CreateUserPage;
import testYouTrack.Pages.LoginPage;
import testYouTrack.Pages.UserListElement;
import testYouTrack.Pages.UsersPage;
import testYouTrack.Util.User;

import java.util.concurrent.TimeUnit;

public class AddUserTest extends BaseTest {
    private User admin;
    private UsersPage usersPage;

    @BeforeTest
    public void DriverInit(){
        // run driver
        setDriver();
        // login
        admin = new User("root", "asdf501");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(admin.getLogin(),admin.getPassword());
    }

    @AfterTest
    public void DriverTearDown(){
        // quit driver
        driver.quit();
    }

    @BeforeMethod
    public void TestInit(){
        System.out.println("Before each");
        usersPage = new UsersPage(driver);
        // go to page by link
        usersPage.visitPage();
        // check if page is shown for logged in user
        Assert.assertTrue(usersPage.pageIsShown());
    }

    @AfterMethod
    public void TestTearDown(){
        System.out.println("After each test");
        //delete test user
        usersPage.visitPage();
        UserListElement userToDelete = usersPage.findUserInListByUserNameStart(UserDataProvider.userNameStart);
        int i=0;
        while (userToDelete!=null && i<10)
        {
            userToDelete.deleteUser();
            i++;
            usersPage.visitPage();
            usersPage = new UsersPage(driver);
            userToDelete = usersPage.findUserInListByUserNameStart(UserDataProvider.userNameStart);
        }
    }

    @Test(dataProvider = "ValidUser", dataProviderClass = UserDataProvider.class)
    public void AddUserPositive(User newUser) {
        // create user
        CreateUserPage createUserPage = usersPage.addNewUser();
        createUserPage.fillAllParams(newUser);
        boolean isUserSaved=createUserPage.saveUser();
        Assert.assertTrue(isUserSaved, "Create user dialog is still shown");
        // check user is added to list
        usersPage = new UsersPage(driver);
        usersPage.visitPage();
        Assert.assertNotNull(usersPage.findUserInList(newUser), "New added user"+newUser.getLogin()
                +" is not found in list");
    }

    @Test(dataProvider = "InvalidUser", dataProviderClass = UserDataProvider.class)
    public void AddUserNegative(User newUser) {
        // create user
        CreateUserPage createUserPage = usersPage.addNewUser();
        createUserPage.fillAllParams(newUser);
        boolean isUserSaved=createUserPage.saveUser();
        Assert.assertFalse(isUserSaved, "Create user dialog is still shown");
        Assert.assertTrue(createUserPage.isErrorShown(), "Error bubble is not shown");
        // close Create user dialog
        createUserPage.cancelDialiog();
        // check user is added to list
        usersPage = new UsersPage(driver);
        usersPage.visitPage();
        Assert.assertNull(usersPage.findUserInList(newUser), "User was created with invalid mandatory params");
    }
}