package co.com.sofka.tasks.service;


import co.com.sofka.interactions.OurGet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DoGet implements Task {

    private String resource;
    public DoGet withResource(String resource){
        this.resource=resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurGet.resource(resource)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );

    }

    public static DoGet doGet(){
        return new DoGet();
    }
}