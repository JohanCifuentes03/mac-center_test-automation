package co.com.sofka.stepdefinitions.service;

import co.com.sofka.config.ServicesUrls;
import co.com.sofka.questions.ResponseDynamicResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.questions.ResponseSoap.responseSoap;
import static co.com.sofka.stepdefinitions.web.WebSetup.actor;
import static co.com.sofka.tasks.service.DoPost.doPost;
import static co.com.sofka.utils.XmlBody.getBody;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class MultiplySoapServiceSD extends ServiceSetup{

    @When("sends a multiply service request with {int} and {int}")
    public void sendsAMultiplyServiceRequestWithAnd(Integer numberOne, Integer numberTwo) {
        String requiredFile = "multiply.xml";
        actor.attemptsTo(
                doPost()
                        .withResource(ServicesUrls.SOAP_RESOURCE)
                        .andHeaders(super.baseSoapHeaders(ServicesUrls.SOAP_MULTIPLY_URL))
                        .andBody(getBody(numberOne, numberTwo, requiredFile))
        );
    }

    @Then("should see {int} in the result for the multiply method")
    public void shouldSeeInTheResultForTheMultiplyMethod(Integer result) {
        actor.should(
                seeThat("result",
                        ResponseDynamicResponse.responseDynamicResponse().forService("Multiply"), equalTo(String.valueOf(result)))
        );
    }
}
