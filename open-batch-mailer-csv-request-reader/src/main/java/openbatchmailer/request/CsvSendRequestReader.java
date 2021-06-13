package openbatchmailer.request;

import openbatchmailer.api.ISendRequestReader;
import openbatchmailer.model.SendRequest;

import java.net.URL;

public class CsvSendRequestReader implements ISendRequestReader {

    private URL csvPath;

    public CsvSendRequestReader(URL csvPath) {
        this.csvPath = csvPath;
    }

    public SendRequest readSendRequest() {
        return null;
    }
}
