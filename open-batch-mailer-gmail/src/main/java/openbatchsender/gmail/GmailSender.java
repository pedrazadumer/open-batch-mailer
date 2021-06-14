package openbatchsender.gmail;

import openbatchmailer.api.IMailer;
import openbatchmailer.model.Destination;
import openbatchmailer.model.Message;
import openbatchsender.gmail.model.UserCredentials;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

public class GmailSender implements IMailer {

    private MailSender mailSender;
    private UserCredentials userCredentials;

    public GmailSender(MailSender mailSender, UserCredentials userCredentials) {
        this.mailSender = mailSender;
        this.userCredentials = userCredentials;
    }

    @Override
    public void send(Message message, List<Destination> destinations) {
        String[] toList = new String[destinations.size()];
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(userCredentials.getEmail());
        mailMessage.setTo(destinations.toArray(toList));
        mailMessage.setText(message.getBody());
        mailMessage.setSubject("GENERIC SUBJECT");

        this.mailSender.send(mailMessage);
    }
}
