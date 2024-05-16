package co.com.sofka.tasks;

import co.com.sofka.ui.CartPage;
import co.com.sofka.ui.SearchItemsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;

public class OpenCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SearchItemsPage.CART_LINK_ICON),
                Wait.until(WebElementQuestion.the(SearchItemsPage.ADDED_ITEM_MESSAGE),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(SearchItemsPage.GO_TO_CART_BTN),
                Wait.until(WebElementQuestion.the(CartPage.CART_TITLE),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );
    }

    public static OpenCart openCart(){
        return new OpenCart();
    }
}
