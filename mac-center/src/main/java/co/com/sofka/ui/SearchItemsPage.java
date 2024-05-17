package co.com.sofka.ui;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;


public class SearchItemsPage extends PageObject {

    public static Target PRODUCTS_LIST_BUTTONS = Target
            .the("the products add buttons")
            .locatedBy("//button[@data-available = 'Agregar al carrito']");

    public static Target ADDED_ITEM_MESSAGE = Target.the("the notification message").located(By.xpath("//span[@class='minicart_title_d']"));
    public static Target CLOSE_ITEM_MESSAGE = Target.the("the close button").located(By.xpath("//a[@id='close-cart1']"));
    public static Target CART_LINK_ICON = Target.the("the cart link button").located(By.xpath("//a[@id = 'cart-icon-bubble']"));
    public static Target GO_TO_CART_BTN = Target.the("the go to the cart button").located(By.xpath("//a[@id='cart-notification-button']"));


    public List<WebElementFacade> listOfProductButtons = PRODUCTS_LIST_BUTTONS.resolveAllFor(getDriver());

    public List<WebElementFacade> getListOfProductButtons() {
        return listOfProductButtons;
    }
}