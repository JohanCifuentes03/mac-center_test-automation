package co.com.sofka.stepdefinitions.service;

import co.com.sofka.config.ServiceUrls;
import co.com.sofka.interactions.OurGet;
import co.com.sofka.models.service.Hero;
import co.com.sofka.models.service.MarvelResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import java.io.IOException;
import java.util.List;


import static co.com.sofka.stepdefinitions.web.WebSetup.actor;

public class GetAllHeroesSD extends ServiceSetup{
    @Given("the user is connected to the Marvel Developer API")
    public void theUserIsConnectedToTheMarvelDeveloperAPI() {
        setupService(ServiceUrls.BASE_URL);
    }

    @When("sends a GET request to retrieve all heroes")
    public void sendsAGETRequestToRetrieveAllHeroes() {
        actor.attemptsTo(
                OurGet.resource(ServiceUrls.GET_ALL_CHARACTERS_URL).with(request ->
                        request.queryParam("ts", 1)
                                .queryParam("apikey", ServiceUrls.PUBLIC_API_KEY)
                                .queryParam("hash", ServiceUrls.HASH)
                )
        );
    }

    @Then("response should contain information about all heroes including")
    public void responseShouldContainInformationAboutAllHeroesIncluding(DataTable dataTable) {
        List<Hero> expectedHeroes = dataTable.asMaps(String.class, String.class).stream()
                .map(row -> new Hero(row.get("id"), row.get("name")))
                .toList();

        String jsonResponse = SerenityRest.lastResponse().getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            MarvelResponse marvelResponse = objectMapper.readValue(jsonResponse, MarvelResponse.class);
            List<Hero> heroes = marvelResponse.getData().getResults();

            for (Hero expectedHero : expectedHeroes) {
                boolean heroFound = heroes.stream()
                        .anyMatch(hero -> hero.getId().equals(expectedHero.getId()) && hero.getName().equals(expectedHero.getName()));

                if (!heroFound) {
                    throw new AssertionError("Hero not found: " + expectedHero.getName() + " with ID " + expectedHero.getId());
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("should receive a response of {int}")
    public void shouldReceiveAResponseOf(Integer statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

}
