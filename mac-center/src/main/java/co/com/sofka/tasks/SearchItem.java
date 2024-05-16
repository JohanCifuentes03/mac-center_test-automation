package co.com.sofka.tasks;

import co.com.sofka.ui.MainPage;
import co.com.sofka.ui.SearchItemsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.Keys;
import java.time.Duration;


public class SearchItem implements Task {
    private String itemName;

    public SearchItem withName (String itemName){
        this.itemName = itemName;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MainPage.SEARCH_INPUT),
                Enter.theValue(itemName, Keys.ENTER).into(MainPage.SEARCH_INPUT),
                Wait.until(WebElementQuestion.the(SearchItemsPage.PRODUCTS_LIST_BUTTONS),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );
    }

    public static SearchItem searchItem(){
        return new SearchItem();
    }
}
