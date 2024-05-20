package co.com.sofka.questions;

import co.com.sofka.models.service.Hero;
import co.com.sofka.models.service.MarvelResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.List;

public class HeroInformation implements Question<Boolean> {
    private final List<Hero> expectedHeroes;

    public HeroInformation(List<Hero> expectedHeroes) {
        this.expectedHeroes = expectedHeroes;
    }

    public static HeroInformation containsInformationAbout(List<Hero> expectedHeroes) {
        return new HeroInformation(expectedHeroes);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String jsonResponse = SerenityRest.lastResponse().getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            MarvelResponse marvelResponse = objectMapper.readValue(jsonResponse, MarvelResponse.class);
            List<Hero> heroes = marvelResponse.getData().getResults();

            for (Hero expectedHero : expectedHeroes) {
                boolean heroFound = heroes.stream()
                        .anyMatch(hero -> hero.getId().equals(expectedHero.getId()) && hero.getName().equals(expectedHero.getName()));

                if (!heroFound) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}