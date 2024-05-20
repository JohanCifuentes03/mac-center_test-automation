package co.com.sofka.stepdefinitions.service;

import co.com.sofka.config.ServiceUrls;
import co.com.sofka.interactions.OurGet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.stepdefinitions.web.WebSetup.actor;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;


public class GetSingleComicSD extends ServiceSetup{
    @When("sends a GET request using id {int}")
    public void sendsAGETRequestUsingId(Integer comicId) {
        actor.attemptsTo(
                OurGet.resource(ServiceUrls.GET_SINGLE_COMIC_URL).with(request ->
                        request.queryParam("ts", 1)
                                .queryParam("apikey", ServiceUrls.PUBLIC_API_KEY)
                                .queryParam("hash", ServiceUrls.HASH)
                                .pathParam("id", comicId)
                )
        );
    }

    @Then("comic name should be {string}")
    public void comicNameShouldBe(String expectedComicTitle) {
        actor.should(
                seeThatResponse("Title should be equal",
                        validatableResponse -> validatableResponse
                                .body("data.results[0].title", equalTo(expectedComicTitle)))
        );
    }
}
