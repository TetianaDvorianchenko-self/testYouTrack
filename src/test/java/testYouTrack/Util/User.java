package testYouTrack.Util;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String login;
    private String fullName;
    private String email;
    private String jabber;
    private String password;
    private String confirmPassword;

    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.confirmPassword= password;
        this.fullName = "";
        this.email = "";
        this.jabber = "";
    }
    public User(String login, String password, HashMap<String, String> optionalParams){
        this.login = login;
        this.password = password;
        this.confirmPassword= password;
        for (Map.Entry<String, String> param: optionalParams.entrySet()) {
            switch (param.getKey().toLowerCase()) {
                case "fullname":
                    this.fullName = param.getValue();
                    break;
                case "email":
                    this.email = param.getValue();
                    break;
                case "jabber":
                    this.jabber = param.getValue();
                    break;
                case "confirmpassword":
                    this.confirmPassword = param.getValue();
                    break;
                default:
                    break;
            }
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJabber() {
        return jabber;
    }

    public void setJabber(String jabber) {
        this.jabber = jabber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
