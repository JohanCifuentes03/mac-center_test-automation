package co.com.sofka.tasks;

import co.com.sofka.models.UserFormModel;
import co.com.sofka.ui.FormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;


public class FillOutForm implements Task {
    private UserFormModel userFormModel;

    public FillOutForm withTheUser(UserFormModel userFormModel) {
        this.userFormModel = userFormModel;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        String idType = "Cédula de Ciudadanía";
        String department = "Bogota DC";
        String city = "BOGOTA /  BARRIOS UNIDOS";

        actor.attemptsTo(
                Enter.theValue(userFormModel.getEmail()).into(FormPage.EMAIL_FIELD),
                SelectFromOptions.byValue(idType).from(FormPage.ID_BOX),
                Enter.theValue(userFormModel.getId()).into(FormPage.ID_INPUT),
                Enter.theValue(userFormModel.getName()).into(FormPage.NAME_INPUT),
                Enter.theValue(userFormModel.getLastname()).into(FormPage.LASTNAME_INPUT),
                Enter.theValue(userFormModel.getDirection()).into(FormPage.ADDRESS_INPUT),
                SelectFromOptions.byValue(department).from(FormPage.DEPARTMENT_BOX),
                SelectFromOptions.byValue(city).from(FormPage.CITY_BOX),
                Enter.theValue(userFormModel.getPhone()).into(FormPage.PHONE_INPUT),
                Scroll.to(FormPage.CONTINUE_BTN)
        );
    }

    public static FillOutForm fillOutForm() {
        return new FillOutForm();
    }

}