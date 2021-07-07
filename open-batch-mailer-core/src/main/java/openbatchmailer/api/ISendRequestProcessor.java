package openbatchmailer.api;

import openbatchmailer.model.SendRequest;

public interface ISendRequestProcessor {

    void processSendRequest(SendRequest sendRequest);

}
