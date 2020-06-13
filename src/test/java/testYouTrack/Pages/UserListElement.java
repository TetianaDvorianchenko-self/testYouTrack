package testYouTrack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserListElement {
    private WebDriver driver;
    private WebElement userElem;
    private WebElement userLoginElem;
    private WebElement userFullNameElem;
    private WebElement userEmailJabberElem;
    private WebElement deletButton;


    private By userLoginLocator =  By.xpath("//td[1]/a");
    private By userFullNameLocator =  By.xpath("//td[2]");
    private By userEmailJabberLocator =  By.xpath("//td[3]");
    private By userGroupsLocator =  By.xpath("//td[4]");

    private By deleteButtonLocator = By.linkText("Delete");

    public UserListElement(WebDriver driver, WebElement user){
        this.driver=driver;
        userElem = user;
        setUserLoginElem();

    }

    public boolean checkUserLogin( String login){
        return getUserLoginElem().getAttribute("title").equals(login);
    }

    public boolean checkUserLoginByStart( String login){
        return getUserLoginElem().getAttribute("title").startsWith(login);
    }

    public boolean checkUserFullName( String text){
        return getUserFullNameElem().getText().equals(text);
    }
    public boolean checkEmail( String text){
        return getUserFullNameElem().getText().contains(text);
    }

    private void setUserLoginElem() {
        userLoginElem = userElem.findElement(userLoginLocator);
    }
    public WebElement getUserLoginElem(){
        return userLoginElem;
    }
    private void setUserFullNameElem() {
        userFullNameElem = userElem.findElement(userFullNameLocator);
    }
    public WebElement getUserFullNameElem(){
        return userFullNameElem;
    }
    private void setUserEmaiJabberElem() {
        userEmailJabberElem = userElem.findElement(userEmailJabberLocator);
    }
    public WebElement getUserEmailJabberElem(){
        return userEmailJabberElem;
    }

    private void setUserDeleleElem() {
        deletButton = userElem.findElement(deleteButtonLocator);
    }
    public WebElement getUserDeleteElem(){
        setUserDeleleElem();
        return deletButton;
    }
    public void deleteUser(){
        WebElement delete = getUserDeleteElem();
        delete.click();
        this.driver.switchTo().alert().accept();
    }


}
