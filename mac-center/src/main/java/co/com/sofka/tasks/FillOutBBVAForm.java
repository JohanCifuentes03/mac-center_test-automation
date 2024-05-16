package co.com.sofka.tasks;

import co.com.sofka.models.CartFormModel;
import co.com.sofka.models.DebitCardModel;
import co.com.sofka.ui.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

public class FillOutBBVAForm implements Task {
    private CartFormModel cartFormModel;
    private DebitCardModel debitCardModel;


    public FillOutBBVAForm withTheUser(CartFormModel cartFormModel) {
        this.cartFormModel = cartFormModel;
        return this;
    }

    public FillOutBBVAForm andTheCard(DebitCardModel debitCardModel) {
        this.debitCardModel = debitCardModel;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Random random = new Random();
        int randomMonth = random.nextInt(1, 13);
        int randomYear = random.nextInt(LocalDate.now().getYear() + 1, LocalDate.now().getYear() + 6);

        String randomMonthS = randomMonth > 9 ? String.valueOf(randomMonth) : "0" + randomMonth;

        actor.attemptsTo(
                Enter.theValue(debitCardModel.getNumber()).into(PaymentPage.CARD_NUMBER_INPUT),
                Enter.theValue((cartFormModel.getName() + " " + cartFormModel.getLastname())).into(PaymentPage.CARD_NUMBER_NAME),
                SelectFromOptions.byValue(randomMonthS).from(PaymentPage.CARD_MONTH_BOX),
                SelectFromOptions.byValue(String.valueOf(randomYear)).from(PaymentPage.CARD_YEAR_BOX),
                Enter.theValue(debitCardModel.getCVV()).into(PaymentPage.CCV_NUMBER_INPUT),
                SelectFromOptions.byValue("1").from(PaymentPage.CARD_INSTALLMENT),
                SelectFromOptions.byValue("CC").from(PaymentPage.ID_TYPE_BOX),
                Enter.theValue(cartFormModel.getId()).into(PaymentPage.DOC_NUMBER_FIELD),
                Scroll.to(PaymentPage.TERMS_CONDITIONS_CHECK_BOX),
                Click.on(PaymentPage.TERMS_CONDITIONS_CHECK_BOX),
                Wait.until(WebElementQuestion.the(PaymentPage.PAY_BUTTON),
                        WebElementStateMatchers.isEnabled()).forNoMoreThan(Duration.ofSeconds(5))
        );


    }

    public static FillOutBBVAForm fillOutBBVAForm() {
        return new FillOutBBVAForm();
    }
}
