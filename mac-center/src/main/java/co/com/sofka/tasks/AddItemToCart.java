package co.com.sofka.tasks;

import co.com.sofka.ui.SearchItemsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AddItemToCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        SearchItemsPage searchItemsPage = new SearchItemsPage();
        List<WebElementFacade> productButtons = searchItemsPage.getListOfProductButtons();

        int sublistSize = productButtons.size() / 4;
        List<WebElementFacade> elements = productButtons.subList(0, sublistSize);

        Random random = new Random();
        int itemIndex = random.nextInt(elements.size());

        actor.attemptsTo(
                Click.on(elements.get(itemIndex)),
                Wait.until(WebElementQuestion.the(SearchItemsPage.ADDED_ITEM_MESSAGE),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(SearchItemsPage.CLOSE_ITEM_MESSAGE));
    }

    public static AddItemToCart addItemToCart() {
        return new AddItemToCart();
    }

}
