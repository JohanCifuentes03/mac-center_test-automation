package co.com.sofka.questions;

import co.com.sofka.ui.AccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LogoutLink implements Question<Boolean> {
    public Boolean answeredBy(Actor actor) {
        return AccountPage.LOGOUT_ACCOUNT_LINK.resolveFor(actor).isEnabled();
    }

    public static LogoutLink logoutLink(){
        return new LogoutLink();
    }
}
