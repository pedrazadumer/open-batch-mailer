package openbatchmailer.api;

import openbatchmailer.model.Destination;
import openbatchmailer.model.Message;

import java.util.List;

public interface IMailer {

    void send(Message message, List<Destination> destinations);

}
