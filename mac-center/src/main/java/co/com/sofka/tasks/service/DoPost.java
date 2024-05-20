package co.com.sofka.tasks.service;

import co.com.sofka.interactions.OurPost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class DoPost implements Task {
    private String resource;
    private Object body;
    private Map<String, Object> headers;

    public DoPost withResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPost andBody(Object body) {
        this.body = body;
        return this;
    }

    public DoPost andHeaders(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurPost.resource(resource).with(
                        requestSpecification -> requestSpecification
                                .headers(headers)
                                .relaxedHTTPSValidation()
                                .body(body)
                )
        );

    }

    public static DoPost doPost() {
        return new DoPost();
    }
}
