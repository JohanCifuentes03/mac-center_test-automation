package co.com.sofka.utils;

import co.com.sofka.models.CartFormModel;
import co.com.sofka.models.DebitCardModel;
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
    public static DebitCardModel createDebitCardNumber(){
        return new DebitCardModel(
                ("4" +  faker.bothify("###############")),
                faker.bothify("###")
        );
    }

}
