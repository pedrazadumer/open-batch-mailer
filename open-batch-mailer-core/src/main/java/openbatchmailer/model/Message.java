package openbatchmailer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String body;

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Message)) return false;
        Message anotherMessage = (Message) other;
        if (this.body != null) {
            return this.body.equals(anotherMessage.body);
        }
        return false;
    }

}
