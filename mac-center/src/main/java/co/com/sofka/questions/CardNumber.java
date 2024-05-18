package co.com.sofka.questions;

import co.com.sofka.ui.PaymentPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

public class CardNumber implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        List<WebElementFacade> digits = PaymentPage.CARD_DIGITS.resolveAllFor(actor);
        return digits.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.joining(""));
    }

    public static CardNumber allDigits(){
        return new CardNumber();
    }
}
