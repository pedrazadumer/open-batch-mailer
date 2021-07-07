package openbatchmailer.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SendRequest {

    private Map<Message, List<Destination>> messageMappings;

}
