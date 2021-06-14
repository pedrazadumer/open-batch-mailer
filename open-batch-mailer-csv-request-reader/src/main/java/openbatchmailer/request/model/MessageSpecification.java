package openbatchmailer.request.model;

import lombok.Data;

import java.net.URL;

@Data
public class MessageSpecification {

    private String recipientList;
    private String ccList;
    private URL csvPath;

}
