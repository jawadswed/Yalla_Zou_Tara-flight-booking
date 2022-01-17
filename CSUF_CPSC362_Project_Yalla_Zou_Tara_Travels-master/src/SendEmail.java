
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.util.*;

public class SendEmail {
public static void send(String toEmail, String msg) {
    final String username = "yallazoutaratravels@gmail.com";
    final String password = "springcpsc362";
    
    String destEmail = toEmail.length() == 0 ? "donavieordonez@gmail.com" : toEmail;

    Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
	prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true");
    
    Session session = Session.getInstance(prop,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            }
    );

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("yallazoutaratravels@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(destEmail));
        message.setSubject("Yalla Zou Tara Travels Ticket Confirmation");
        message.setText("Hello, This is your flight ticket confirmation:\n\n" + msg + "\n\nThanks for booking with us!"); 

        Transport.send(message);
        
    } catch (MessagingException e) {
        e.printStackTrace();
    }
}
}
