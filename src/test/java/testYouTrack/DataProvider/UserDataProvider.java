package testYouTrack.DataProvider;

import org.testng.annotations.DataProvider;
import testYouTrack.Util.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class UserDataProvider {

    public static String userNameStart = "autotest";
    private static int randomInt(){
        Random rand = new Random();
        return rand.nextInt(10000);
    }
    @DataProvider(name = "ValidUser")
    public static Object[][] dpValidUser()
    {
        return new Object[][] {
                {
                    new User(userNameStart+randomInt(),"Abcd1234", new HashMap(){{
                        put("fullName", "user one");
                        put("email", "testuser1@gmail.com");}})},
                {
                    new User(userNameStart+randomInt(),"Abcd1234", new HashMap(){{
                        put("fullName", "user two");
                        put("jabber", "someJabber");}})
                },
                {   new User(userNameStart+randomInt(),"Abcd1234", new HashMap(){{
                        put("jabber", "someJabber");
                        put("email", "testuser1@gmail.com");}})
                }
        };
    }

    @DataProvider(name = "InvalidUser")
    public static Object[][] dpInvalidUser()
    {
        return new Object[][] {
                {
                    new User("","Abcd1234", new HashMap(){{
                        put("fullName", "user one");
                        put("email", "testuser1@gmail.com");}})
                },
                {
                    new User(userNameStart+randomInt(),"", new HashMap(){{
                        put("fullName", "user one");
                        put("jabber", "someJabber");}})
                },
                {     new User("","", new HashMap())},
                {
                    new User(userNameStart+randomInt(),"Abcd1234", new HashMap(){{
                        put("confirmPassword", "anotherPASS"); }})
                }
        };
    }
}
