package com.example.wssec.endpoint;

import com.example.wssec.GetCityRequest;
import com.example.wssec.GetCityResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CityEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/wssec";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCityRequest")
    @ResponsePayload
    public GetCityResponse getCity(@RequestPayload GetCityRequest request) {
        GetCityResponse response = new GetCityResponse();
        response.setCityName(request.getName());
        response.setPopulation(8000000);
        return response;
    }
}
