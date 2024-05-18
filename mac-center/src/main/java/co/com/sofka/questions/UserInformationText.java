package co.com.sofka.questions;

import co.com.sofka.ui.AccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserInformationText implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return AccountPage.NAME_LABEL.resolveFor(actor).getText();
    }

    public static UserInformationText userInformationText(){
        return new UserInformationText();
    }
}
