package co.com.sofka.tasks;

import co.com.sofka.models.CartFormModel;
import co.com.sofka.models.DebitCardModel;
import co.com.sofka.ui.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class FillOutBBVAForm implements Task {
    private CartFormModel cartFormModel;
    private DebitCardModel debitCardModel;


    public FillOutBBVAForm withTheUser(CartFormModel cartFormModel){
        this.cartFormModel = cartFormModel;
        return this;
    }

    public FillOutBBVAForm andTheCard(DebitCardModel debitCardModel){
        this.debitCardModel = debitCardModel;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaymentPage.BBVA_PAYMENT_OPTION),
                Scroll.to(PaymentPage.CARD_NUMBER_INPUT),
                Enter.theValue(debitCardModel.getNumber()).into(PaymentPage.CARD_NUMBER_INPUT),
                Enter.theValue((cartFormModel.getName() + " " + cartFormModel.getLastname())).into(PaymentPage.CARD_NUMBER_NAME)
        );
    }

    public static FillOutBBVAForm fillOutBBVAForm(){
        return new FillOutBBVAForm();
    }
}
