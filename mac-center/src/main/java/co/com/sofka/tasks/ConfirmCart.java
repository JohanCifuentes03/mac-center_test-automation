package co.com.sofka.tasks;

import co.com.sofka.ui.CartPage;
import co.com.sofka.ui.FormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;

public class ConfirmCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CONFIRM_CART_BTN),
                Wait.until(WebElementQuestion.the(FormPage.INPUT_FIELD),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );
    }
}
