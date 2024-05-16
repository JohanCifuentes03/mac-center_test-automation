package co.com.sofka.tasks;

import co.com.sofka.ui.FormPage;
import co.com.sofka.ui.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;

public class ContinueToPayment implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FormPage.CONTINUE_BTN),
                Wait.until(WebElementQuestion.the(PaymentPage.CONTINUE_PAYMENT_BTN),
                        WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(PaymentPage.CONTINUE_PAYMENT_BTN),
                Wait.until(WebElementQuestion.the(PaymentPage.BBVA_PAYMENT_OPTION),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );
    }

    public static ContinueToPayment continueToPayment(){
        return new ContinueToPayment();
    }
}
