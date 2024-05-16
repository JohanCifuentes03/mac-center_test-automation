package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaymentPage extends PageObject {
    public static Target CONTINUE_PAYMENT_BTN = Target
            .the("continue payment button")
            .located(By.xpath("//button/span[contains(text(), 'método de pago')]/ancestor::button"));

    public static Target BBVA_PAYMENT_OPTION = Target
            .the("continue BBVA payment option")
            .located(By.xpath("//span[contains(text(), 'BBVA')]/ancestor::div[contains(@class, 'row')]"));

    public static Target CARD_NUMBER_INPUT = Target
            .the("the card number input")
            .located(By.xpath("//input[@id = 'cardNumber']"));

    public static Target CARD_NUMBER_NAME = Target
            .the("the card name input")
            .located(By.xpath("//input[@id = 'cardName']"));

    public static Target CARD_MONTH_BOX = Target
            .the("the card month box")
            .located(By.xpath("//input[@id = 'cardMonth']"));

    public static Target CARD_YEAR_BOX = Target
            .the("the card year box")
            .located(By.xpath("//input[@id = 'cardYear']"));

    public static Target CARD_INSTALLMENT = Target
            .the("the card installment box")
            .located(By.xpath("//input[@id = 'installmentsSelect']"));


}
