package openbatchmailer.model;

import lombok.Data;

import java.util.List;

@Data
public class Destination {

    private List<String> recipientList;
    private List<String> ccList;
    private List<String> bccList;

}
