package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.PaymentPage.PAY_BUTTON;

public class PayButtonEnabled implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return PAY_BUTTON.resolveFor(actor).isEnabled();
    }

    public static PayButtonEnabled paymentButtonEnabled(){
        return new PayButtonEnabled();
    }

}
