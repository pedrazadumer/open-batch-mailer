package openbatchmailer;

import openbatchmailer.model.Message;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class DestinationComparisonTest {

    public static final String TEST_MESSAGE_BODY = "The Test Message Body.";
    public static final String A_DIFFERENT_MESSAGE_BODY = "A different message";
    public static final String MESSAGE_A_KEY = "MessageAKey";
    public static final String MESSAGE_B_KEY = "MessageBKey";


    @Test
    public void shouldReturnFalseWithDifferentMessages() {
        Message messageA = new Message();
        Message messageB = new Message(TEST_MESSAGE_BODY, Collections.emptyList());

        assertFalse(messageA.equals(messageB));
    }

    @Test
    public void shouldReturnTrueWithEquivalentMessages() {
        Message messageA = new Message(TEST_MESSAGE_BODY, Collections.emptyList());
        Message messageB = new Message(TEST_MESSAGE_BODY, Collections.emptyList());

        assertTrue(messageA.equals(messageB));
    }

    @Test
    public void shouldReturnTheCorrectMessageKey() {
        Message messageA = new Message(A_DIFFERENT_MESSAGE_BODY, Collections.emptyList());
        Message messageB = new Message(TEST_MESSAGE_BODY, Collections.emptyList());

        Map<Message, String> messageMapping = new HashMap<>();
        messageMapping.put(messageA, MESSAGE_A_KEY);
        messageMapping.put(messageB, MESSAGE_B_KEY);

        assertEquals(MESSAGE_A_KEY, messageMapping.get(messageA));
        assertEquals(MESSAGE_B_KEY, messageMapping.get(messageB));
    }
}
