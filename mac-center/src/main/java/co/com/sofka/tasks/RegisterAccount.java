package co.com.sofka.tasks;

import co.com.sofka.models.UserFormModel;
import co.com.sofka.ui.FormPage;
import co.com.sofka.ui.LoginPage;
import co.com.sofka.ui.MainPage;
import co.com.sofka.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;

public class RegisterAccount implements Task {
    private UserFormModel userFormModel;

    public RegisterAccount withTheUser(UserFormModel userFormModel) {
        this.userFormModel = userFormModel;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userFormModel.getName()).into(RegisterPage.NAME_INPUT),
                Enter.theValue(userFormModel.getLastname()).into(RegisterPage.LASTNAME_INPUT),
                Enter.theValue(userFormModel.getEmail()).into(RegisterPage.EMAIL_INPUT),
                Enter.theValue(userFormModel.getPassword()).into(RegisterPage.PASSWORD_INPUT),
                Click.on(RegisterPage.PASSWORD_CONFIRM_BTN),
                Wait.until(WebElementQuestion.the(MainPage.BANNER_PIVOT),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(5))

        );
    }

    public static RegisterAccount registerAccount() {
        return new RegisterAccount();
    }
}
