package openbatchsender.gmail.config;

import openbatchmailer.api.IMailer;
import openbatchsender.gmail.GmailSender;
import openbatchsender.gmail.model.UserCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {

    @Bean
    public UserCredentials userCredentials() {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setEmail("abc@gmail.com");
        userCredentials.setPassword("The Password");
        return userCredentials;
    }

    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
        mailsender.setHost("smtp.gmail.com");
        mailsender.setUsername(userCredentials().getEmail());
        mailsender.setPassword(userCredentials().getPassword());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.socketFactory.port", 465);
        javaMailProperties.put("mail.smtp.socketFactory.class", javax.net.ssl.SSLSocketFactory.class);
        javaMailProperties.put("mail.smtp.port", 465);

        //javaMailProperties.put("mail.smtp.starttls.enable", "true");
        //javaMailProperties.put("mail.transport.protocol", "smtp");
        //javaMailProperties.put("mail.debug", "true");

        return mailsender;
    }

    @Bean
    public IMailer gmailSender() {
        return new GmailSender(mailSender(), userCredentials());
    }
}
