package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class FormPage extends PageObject {
    public static Target INPUT_FIELD = Target.the("the input field").located(By.xpath("//input[@id = 'checkout_email_or_phone']"));

}
