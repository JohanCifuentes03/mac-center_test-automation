package co.com.sofka.questions;

import co.com.sofka.models.service.Character;
import co.com.sofka.models.service.MarvelResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharactersResponse implements Question<List<Character>> {

    public List<Character> answeredBy(Actor actor) {
        String jsonResponse = SerenityRest.lastResponse().getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            MarvelResponse marvelResponse = objectMapper.readValue(jsonResponse, MarvelResponse.class);
            return marvelResponse.getData().getResults();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static CharactersResponse charactersResponse(){
        return new CharactersResponse();
    }
}