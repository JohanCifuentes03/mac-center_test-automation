package co.com.sofka.questions;

import io.restassured.path.xml.XmlPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.nio.charset.StandardCharsets;

public class ResponseDynamicResponse implements Question<String> {
    private String service;
    public ResponseDynamicResponse forService(String service){
        this.service = service;
        return this;
    }

    @Override
    public String answeredBy(Actor actor) {
        String xmlString = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        XmlPath xmlPath = new XmlPath(xmlString);
        String xpathExpression = String.format("**.find { it.name() == '%sResult' }.text()", service);
        return xmlPath.getString(xpathExpression);
    }

    public static ResponseDynamicResponse responseDynamicResponse(){
        return new ResponseDynamicResponse();
    }
}
