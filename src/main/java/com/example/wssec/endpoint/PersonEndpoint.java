package com.example.wssec.endpoint;

import com.example.wssec.AddPersonRequest;
import com.example.wssec.AddPersonResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/demo";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public AddPersonResponse getPerson(@RequestPayload AddPersonRequest request) {
        // Logic to add the person
        AddPersonResponse response = new AddPersonResponse();
        response.setStatus("Success");
        response.setPersonId(123);
        return response;
    }
}
