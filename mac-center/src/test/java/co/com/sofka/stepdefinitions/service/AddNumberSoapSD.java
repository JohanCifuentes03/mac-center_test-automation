package co.com.sofka.stepdefinitions.service;

import co.com.sofka.config.ServicesUrls;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.jetbrains.annotations.NotNull;


import static co.com.sofka.questions.ResponseSoap.responseSoap;
import static co.com.sofka.stepdefinitions.web.WebSetup.actor;
import static co.com.sofka.tasks.service.DoPost.doPost;
import static co.com.sofka.utils.FileUtil.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class AddNumberSoapSD extends ServiceSetup{

    @Given("the user has access to SOAP services")
    public void theUserHasAccessToSOAPServices() {
        setupService(ServicesUrls.SOAP_BASE_URL);
    }
    @When("sends an add service request with {int} and {int}")
    public void sendsAnAddServiceRequestWithAnd(Integer numberOne, Integer numberTwo) {
        actor.attemptsTo(
                doPost()
                        .withResource(ServicesUrls.SOAP_RESOURCE)
                        .andHeaders(super.baseSoapHeaders(ServicesUrls.SOAP_ADD_URL))
                        .andBody(getBody(numberOne, numberTwo))
        );
    }
    @Then("should see {int} in the result")
    public void shouldSeeInTheResult(Integer result) {
        actor.should(
                seeThat("result",
                        responseSoap(), containsString(String.valueOf(result))
                )
        );
    }

    private static @NotNull String getBody(int valueUno, int valueDos) {
        return String.format(readFile("src/test/resources/xml/add.xml"), valueUno, valueDos);
    }
}
