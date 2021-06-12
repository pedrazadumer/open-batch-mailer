package openbatchmailer.api;

import openbatchmailer.model.Destination;
import openbatchmailer.model.Message;

import java.util.List;
import java.util.Map;

public interface IBatchMailer {

    void send(Map<Message, List<Destination>> messageMappings);

}
