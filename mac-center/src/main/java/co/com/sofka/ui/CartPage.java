package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CartPage extends PageObject {
    public static Target CART_TITLE = Target.the("the titile").located(By.xpath("//h1[@class='title title--primary']"));
    public static Target CONFIRM_CART_BTN = Target.the("the confirm purchase button").located(By.xpath("//button[@id = 'checkout']"));
}
