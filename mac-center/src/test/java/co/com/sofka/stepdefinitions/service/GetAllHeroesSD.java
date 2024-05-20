package co.com.sofka.stepdefinitions.service;

import co.com.sofka.config.ServicesUrls;
import co.com.sofka.interactions.OurGet;
import co.com.sofka.models.service.Character;
import co.com.sofka.questions.CharactersResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;


import static co.com.sofka.stepdefinitions.web.WebSetup.actor;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class GetAllHeroesSD extends ServiceSetup {
    @Given("the user is connected to the Marvel Developer API")
    public void theUserIsConnectedToTheMarvelDeveloperAPI() {
        setupService(ServicesUrls.BASE_URL);
    }

    @When("sends a GET request to retrieve all heroes")
    public void sendsAGETRequestToRetrieveAllHeroes() {
        actor.attemptsTo(
                OurGet.resource(ServicesUrls.GET_ALL_CHARACTERS_URL).with(request ->
                        request.queryParam("ts", 1)
                                .queryParam("apikey", ServicesUrls.PUBLIC_API_KEY)
                                .queryParam("hash", ServicesUrls.HASH)
                )
        );
    }
    @Then("response should contain information about all heroes including")
    public void responseShouldContainInformationAboutAllHeroesIncluding(List<Character> expectedCharacters) {
        List<Character> charactersResponse = CharactersResponse.charactersResponse().answeredBy(actor);
        System.out.println(charactersResponse);
        expectedCharacters.forEach(character -> {
            assertThat(charactersResponse, hasItem(character));
        });
    }


    @Then("should receive a response of {int}")
    public void shouldReceiveAResponseOf(Integer statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

}
