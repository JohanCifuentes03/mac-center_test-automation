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

public class SubtractSoapServiceSD extends ServiceSetup{

    @When("sends a subtract service request with {int} and {int}")
    public void sendsASubtractServiceRequestWithAnd(Integer numberOne, Integer numberTwo) {
        String requiredFile = "subtract.xml";
        actor.attemptsTo(
                doPost()
                        .withResource(ServicesUrls.SOAP_RESOURCE)
                        .andHeaders(super.baseSoapHeaders(ServicesUrls.SOAP_SUBTRACT_URL))
                        .andBody(getBody(numberOne, numberTwo, requiredFile))
        );
    }

    @Then("should see {int} in the result for the subtract method")
    public void shouldSeeInTheResultForTheSubtractMethod(Integer result) {
        actor.should(
                seeThat("result",
                        ResponseDynamicResponse.responseDynamicResponse().forService("Subtract"), equalTo(String.valueOf(result)))
        );
    }
}
