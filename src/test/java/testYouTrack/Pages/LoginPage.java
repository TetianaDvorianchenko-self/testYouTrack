package testYouTrack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(id="id_l.L.login")
    private WebElement loginField;

    @FindBy(id="id_l.L.password")
    private WebElement passwordField;

    @FindBy(id="id_l.L.rememberMe")
    private WebElement rememberMeCheckbox;

    @FindBy(id="id_l.L.loginButton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        pageUrl = "/login";
        visitPage();
        PageFactory.initElements(this.driver, this);
    }

    public void submitLogin(){
        loginButton.click();
    }

    public void login(String login, String pass){
        fillField(loginField,login);
        fillField(passwordField,pass);
        submitLogin();
    }



}
