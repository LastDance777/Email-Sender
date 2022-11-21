package app;

import app.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Mail {
    public boolean SendEmail(String to, String subject, String msg_body) {
        String from = "enter your email here";
        String password = "enter your app password here";
        boolean mail_status = false;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        MyAuth auth = new MyAuth(from, password);
        auth.getPasswordAuthentication();
        props.put("mail.debug", "true");
        Session ses = (Session) Session.getInstance(props, auth);
        try {
            Message msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] addresses = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, addresses);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(msg_body);
            Transport.send(msg);
            mail_status = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.err.println("status : "+mail_status);
        return mail_status;
    }
}



