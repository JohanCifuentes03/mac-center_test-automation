package co.com.sofka.stepdefinitions.service;

import co.com.sofka.stepdefinitions.web.WebSetup;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

public class ServiceSetup {
    protected void setupService(String baseUrl){
        WebSetup.actor.can(CallAnApi.at(baseUrl));
    }

    protected HashMap<String, Object> baseSoapHeaders(String resource) {
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type", "text/xml;charset=UTF-8");
        headersCollection.put("SOAPAction", resource);

        return headersCollection;
    }

}
