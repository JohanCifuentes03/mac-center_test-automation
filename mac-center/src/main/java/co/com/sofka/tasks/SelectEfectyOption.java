package co.com.sofka.tasks;


import co.com.sofka.ui.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class SelectEfectyOption implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaymentPage.EFECTY_PAYMENT_OPTION),
                Scroll.to(PaymentPage.EFECTY_DOCUMENT_BOX)
        );
    }

    public static SelectEfectyOption selectEfectyOption(){
        return new SelectEfectyOption();
    }
}
