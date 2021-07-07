package openbatchmailer.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Destination {

    private List<String> recipientList = new ArrayList<>();
    private List<String> ccList = new ArrayList<>();
    private List<String> bccList = new ArrayList<>();

}
