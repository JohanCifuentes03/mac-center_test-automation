package co.com.sofka.hooks;

import co.com.sofka.models.service.Character;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CharacterConfig {

    @DataTableType
    public Character mapToCharacter(Map<String, String> heroesData){
        return new Character(
                heroesData.get("id"),
                heroesData.get("name")
        );
    }
}
