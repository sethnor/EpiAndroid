package eu.epitech.sami.epiandroid;

/**
 * Created by tester on 27/01/2016.
 */
public class Token {
    public static String token;
    public static String login;

    public void setToken(String newtoken)
    {
        token = newtoken;
    }

    public String getToken()
    {
        return token;
    }

    public void setLogin(String newlogin)
    {
        login = newlogin;
    }

    public String getLogin()
    {
        return login;
    }
}
