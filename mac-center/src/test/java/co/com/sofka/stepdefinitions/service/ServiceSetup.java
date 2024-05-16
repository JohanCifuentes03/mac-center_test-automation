package co.com.sofka.stepdefinitions.service;

import co.com.sofka.stepdefinitions.web.WebSetup;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ServiceSetup {
    protected void setupService(String baseUrl){
        WebSetup.actor.can(CallAnApi.at(baseUrl));
    }
}
