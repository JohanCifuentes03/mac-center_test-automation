package co.com.sofka.utils;

import co.com.sofka.models.CartFormModel;
import net.datafaker.Faker;

public class CreateModel {
    private static final Faker faker = new Faker();

    public static CartFormModel createCartFormModel(){
        return new CartFormModel(
                faker.internet().emailAddress(),
                faker.bothify("###########"),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().fullAddress(),
                ("31" + faker.bothify("########"))
        );
    }
}
