package testYouTrack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testYouTrack.Util.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateUserPage extends BasePage{

    @FindBy(id = "id_l.U.cr.login")
    private WebElement login;

    @FindBy(id = "id_l.U.cr.password")
    private WebElement password;

    @FindBy(id = "id_l.U.cr.confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "id_l.U.cr.fullName")
    private WebElement fullName;

    @FindBy(id = "id_l.U.cr.email")
    private WebElement email;

    @FindBy(id = "id_l.U.cr.jabber")
    private WebElement jabber;

    @FindBy(id = "id_l.U.cr.createUserOk")
    private WebElement saveButton;

    @FindBy(id = "id_l.U.cr.createUserCancel")
    private WebElement cancelButton;

    @FindBy(id ="id_l.U.cr.createUserDialog")
    private WebElement dialogContainer;

    @FindBy (className = "error-bulb2")
    private WebElement errorBulb;

    public CreateUserPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isDialogShown(){
        try {
             dialogContainer.isDisplayed();
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public void fillAllParams(User user){
        fillField(login,user.getLogin());
        fillField(password,user.getPassword());
        fillField(confirmPassword,user.getConfirmPassword());
        fillField(fullName,user.getFullName());
        fillField(email,user.getEmail());
        fillField(jabber,user.getJabber());
    }
    public boolean saveUser(){
        saveButton.click();
        if (!isErrorShown()){
            try{
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.invisibilityOf(dialogContainer));
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }

    public void cancelDialiog(){
        cancelButton.click();
    }

    public boolean isErrorShown(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.visibilityOf(errorBulb));
        }catch(Exception E){
            return false;
        }
        return true;
    }
}
