package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static Target REGISTER_LINK = Target
            .the("the register link")
            .located(By.xpath("//a[normalize-space()='Crear cuenta']"));

}
