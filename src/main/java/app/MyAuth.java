package app;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuth extends Authenticator {
    String UserName = null;
    String Password = null;

    public MyAuth(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(UserName,Password);
    }
}