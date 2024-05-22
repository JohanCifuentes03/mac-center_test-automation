package co.com.sofka.stepdefinitions.service;

import co.com.sofka.config.ServicesUrls;
import co.com.sofka.questions.ResponseDynamicResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.stepdefinitions.web.WebSetup.actor;
import static co.com.sofka.tasks.service.DoPost.doPost;
import static co.com.sofka.utils.XmlBody.getBody;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddSoapServiceSD extends ServiceSetup{

    @Given("the user has access to SOAP services")
    public void theUserHasAccessToSOAPServices() {
        setupService(ServicesUrls.SOAP_BASE_URL);
    }

    @When("sends an add service request with {int} and {int}")
    public void sendsAnAddServiceRequestWithAnd(Integer numberOne, Integer numberTwo) {
        String requiredFile = "add.xml";
        actor.attemptsTo(
                doPost()
                        .withResource(ServicesUrls.SOAP_RESOURCE)
                        .andHeaders(super.baseSoapHeaders(ServicesUrls.SOAP_ADD_URL))
                        .andBody(getBody(numberOne, numberTwo, requiredFile))
        );
    }

    @Then("should see {int} in the result for the add method")
    public void shouldSeeInTheResultForTheAddMethod(Integer result) {
        actor.should(
                seeThat("result",
                        ResponseDynamicResponse.responseDynamicResponse().forService("Add"), equalTo(String.valueOf(result)))
        );
    }
}
