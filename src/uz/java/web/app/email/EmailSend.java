package uz.java.web.app.email;

import uz.java.web.app.dto.UserData;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSend {

    public static void sendEmail(String userName, String password1, String firtName, String lastName) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("group2017students@gmail.com","info2017group");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("group2017students@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userName));
            message.setSubject("Sizni tabriklaymiz ragistratsiya bilan!");
            message.setText("Xurmatli," +
                    "\n\n "+firtName+" "+lastName+
                    "\n Siz bizni systemaga muaffaqiyatli registratsiyadan utdingiz" +
                    "\n" +
                    "\n" +
                    "Login:" + userName+
                    "\n" +
                     "Parol: "+password1);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
