package co.com.sofka.utils;

import co.com.sofka.models.UserFormModel;
import co.com.sofka.models.DebitCardModel;
import net.datafaker.Faker;

public class CreateModel {
    private static final Faker faker = new Faker();

    public static UserFormModel createCartFormModel() {
        return new UserFormModel(
                faker.internet().emailAddress(),
                ("1" + faker.bothify("##########")),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().password(),
                faker.address().fullAddress(),
                ("31" + faker.bothify("########"))
        );
    }

    public static DebitCardModel createDebitCardNumber() {
        return new DebitCardModel(
                ("4" + faker.bothify("###############")),
                ("1" + faker.bothify("##"))
        );
    }

}
