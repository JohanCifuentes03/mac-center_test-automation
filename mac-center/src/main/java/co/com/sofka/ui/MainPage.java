package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class MainPage extends PageObject {
    public static Target SEARCH_INPUT = Target.the("the search box").located(By.xpath("//form[@id='nosubmit_form2']//input"));
}
