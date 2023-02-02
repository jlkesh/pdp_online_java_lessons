## Sending email using gmail
````java
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GmailService {

    private static final String username = "your gmail here";
    private static final String password = "your app password here";

    public static void main(String[] args) throws MessagingException {

        var properties = getProperties();
        var session = getSession(properties, username, password);
        var message = new MimeMessage(session);
        var recipient = "recipient@gmail.com";

        message.setSubject("This is Subject For Test Message");
        message.setContent("<h1 style=\"color:red;\">Body of mail here</h1>","text/html");
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        Transport.send(message);
        System.out.println("Message Sent Successfully");
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }


    private static Session getSession(Properties properties, String username, String password) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}
````

## Sending email using mailtrap
````java
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Properties;

public class MailtrapService {
    
    private static final String username = "your mailtrap username here";
    private static final String password = "your mailtrap password here";
    
    public static void main(String[] args) throws Exception {
    
        var properties = getProperties();
        var session = getSession(properties, username, password);
        var message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("recipient@gmail.com"));
        message.setSubject("This is Subject For Test Message");
        var multipart = new MimeMultipart();
        
        var attachment1 = new MimeBodyPart();
        var fileDataSource = new FileDataSource("cv.txt");
        var dataHandler = new DataHandler(fileDataSource);
        attachment1.setFileName("MyCV.txt");
        attachment1.setDataHandler(dataHandler);

        var attachment2 = new MimeBodyPart();
        var fileDataSource2 = new FileDataSource("samples.txt");
        var dataHandler2 = new DataHandler(fileDataSource2);
        attachment2.setFileName("CodeSamples.txt");
        attachment2.setDataHandler(dataHandler2);

        var contentMessage = new MimeBodyPart();
        String body = """
                <div>
                <h1 style="color:red;">Body of mail here</h1>
                <img src="data:image/jpg;base64,%s" width=1000 >
                </div>
                """.formatted(getImageAsBase64());
        contentMessage.setContent(body, "text/html");

        multipart.addBodyPart(attachment1);
        multipart.addBodyPart(attachment2);
        multipart.addBodyPart(contentMessage);
        message.setContent(multipart);
        Transport.send(message);
        System.out.println("Message Sent Successfully");
    }

    private static String getImageAsBase64() throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        Path path = Path.of("animal.jpg");
        byte[] allBytes = Files.readAllBytes(path);
        String encodeToString = encoder.encodeToString(allBytes);
        Files.writeString(Path.of("imageAstring.txt"), encodeToString, StandardOpenOption.TRUNCATE_EXISTING);
        return encodeToString;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }


    private static Session getSession(Properties properties, String username, String password) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}
````