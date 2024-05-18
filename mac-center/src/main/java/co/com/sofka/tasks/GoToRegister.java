package co.com.sofka.tasks;

import co.com.sofka.ui.LoginPage;
import co.com.sofka.ui.PaymentPage;
import co.com.sofka.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;

public class GoToRegister implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginPage.REGISTER_LINK),
                Wait.until(WebElementQuestion.the(RegisterPage.NAME_INPUT),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(5))
        );
    }

    public static GoToRegister goToRegister() {
        return new GoToRegister();
    }
}
