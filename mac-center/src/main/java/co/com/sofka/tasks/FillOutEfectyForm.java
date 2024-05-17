package co.com.sofka.tasks;


import co.com.sofka.models.UserFormModel;
import co.com.sofka.ui.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;


public class FillOutEfectyForm implements Task {
    private UserFormModel userFormModel;

    public FillOutEfectyForm withTheUser(UserFormModel userFormModel) {
        this.userFormModel = userFormModel;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byValue("efecty").from(PaymentPage.EFECTY_PAYMENT_BOX),
                SelectFromOptions.byValue("CC").from(PaymentPage.EFECTY_DOCUMENT_BOX),
                Enter.theValue(userFormModel.getId()).into(PaymentPage.EFECTY_DOCUMENT_NUMBER),
                Click.on(PaymentPage.TERMS_CONDITIONS_CHECK_BOX),
                Wait.until(WebElementQuestion.the(PaymentPage.PAY_BUTTON),
                        WebElementStateMatchers.isEnabled()).forNoMoreThan(Duration.ofSeconds(5))
        );
    }

    public static FillOutEfectyForm fillOutEfectyForm() {
        return new FillOutEfectyForm();
    }
}
