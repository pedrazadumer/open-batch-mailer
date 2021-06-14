package openbatchmailer;

import openbatchmailer.api.ISendRequestReader;
import openbatchmailer.model.Destination;
import openbatchmailer.model.SendRequest;
import openbatchmailer.request.CsvSendRequestReader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class CsvSendRequestReaderTests {

    private static final String TEST_MESSAGE_BODY = "The Test Message Body";

    @Test
    public void shouldReadTestCsv() throws IOException {
        URL testSendRequestURL = new URL("file:src/test/resources/test-send-request.csv");
        Map<String, URL> messageCsvMappings = new HashMap<>();
        messageCsvMappings.put(TEST_MESSAGE_BODY, testSendRequestURL);
        ISendRequestReader sendRequestReader = new CsvSendRequestReader(messageCsvMappings);
        SendRequest sendRequest = sendRequestReader.readSendRequest();

        assertNotNull(sendRequest);
        assertNotNull(sendRequest.getMessageMappings());
        assertEquals(1, sendRequest.getMessageMappings().size());
        List<Destination> destinationList = sendRequest.getMessageMappings().entrySet().iterator().next().getValue();
        assertEquals(2, destinationList.size());
        assertEquals(1, destinationList.get(0).getRecipientList().size());
        assertEquals(2, destinationList.get(1).getRecipientList().size());
        assertEquals(1, destinationList.get(0).getCcList().size());
        assertEquals(2, destinationList.get(1).getCcList().size());
    }

    private static void testFilePath(String filePathToTest) throws IOException {
        URL folder = new URL(filePathToTest);
        InputStream inputStream = (InputStream) folder.getContent();
        Scanner in = new Scanner(inputStream);
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
    }
}
