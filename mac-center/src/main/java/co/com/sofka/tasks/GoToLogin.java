package co.com.sofka.tasks;

import co.com.sofka.ui.MainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


public class GoToLogin implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MainPage.LOGIN_ICON)
        );
    }

    public static GoToLogin goToLogin() {
        return new GoToLogin();
    }
}
