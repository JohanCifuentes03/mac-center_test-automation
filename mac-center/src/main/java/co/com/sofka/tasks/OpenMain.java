package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenMain implements Task {
    private String url;

    public OpenMain withTheUrl(String url){
        this.url = url;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
    public static OpenMain openMainPage(){
        return new OpenMain();
    }
}
