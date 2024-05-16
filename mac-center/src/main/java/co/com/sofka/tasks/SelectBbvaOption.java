package co.com.sofka.tasks;

import co.com.sofka.ui.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class SelectBbvaOption implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaymentPage.BBVA_PAYMENT_OPTION),
                Scroll.to(PaymentPage.CARD_NUMBER_INPUT)
        );
    }

    public static SelectBbvaOption selectBbvaOption(){
        return new SelectBbvaOption();
    }
}
