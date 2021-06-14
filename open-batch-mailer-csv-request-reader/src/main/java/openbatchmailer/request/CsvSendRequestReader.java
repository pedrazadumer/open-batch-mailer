package openbatchmailer.request;

import openbatchmailer.api.ISendRequestReader;
import openbatchmailer.model.Destination;
import openbatchmailer.model.Message;
import openbatchmailer.model.SendRequest;
import openbatchmailer.request.model.MessageSpecification;
import openbatchmailer.request.util.GenericCsvReader;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvSendRequestReader implements ISendRequestReader {

    private Map<String, URL> messageCsvMappings;

    public CsvSendRequestReader(Map<String, URL> messageCsvMappings) {
        this.messageCsvMappings = messageCsvMappings;
    }

    public SendRequest readSendRequest() {
        SendRequest sendRequest = new SendRequest();
        Map<Message, List<Destination>> messageMappings = readMessageMappings();
        sendRequest.setMessageMappings(messageMappings);
        return sendRequest;
    }

    private Map<Message, List<Destination>> readMessageMappings() {
        return this.messageCsvMappings.entrySet().stream()
                .collect(Collectors.toMap(this::mapMessageFromBody, this::readDestinationsForMessage));
    }

    private Message mapMessageFromBody(Map.Entry<String, URL> e) {
        return new Message(e.getKey(), Collections.singletonList(e.getValue()));
    }

    private List<Destination> readDestinationsForMessage(Map.Entry<String, URL> entry) {
        List<MessageSpecification> messageSpecifications =
                GenericCsvReader.loadObjectList(MessageSpecification.class, entry.getValue());

        return messageSpecifications.stream()
                .map(this::mapDestinationFromMessageSpecification)
                .collect(Collectors.toList());
    }

    private Destination mapDestinationFromMessageSpecification(MessageSpecification messageSpecification) {
        Destination destination = new Destination();
        destination.setRecipientList(Arrays.asList(messageSpecification.getRecipientList().split(";")));
        destination.setCcList(Arrays.asList(messageSpecification.getCcList().split(";")));
        return destination;
    }
}
