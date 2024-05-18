package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaymentPage extends PageObject {

    public static Target CONTINUE_PAYMENT_BTN = Target
            .the("continue payment button")
            .located(By.xpath("//button/span[contains(text(), 'método de pago')]/ancestor::button"));

    public static Target BBVA_PAYMENT_OPTION = Target
            .the("continue BBVA payment option")
            .located(By.xpath("//span[contains(text(), 'Pago tarjetas')]/ancestor::div[contains(@class, 'row')]"));

    public static Target EFECTY_PAYMENT_OPTION = Target
            .the("continue efecty payment option")
            .located(By.xpath("//span[contains(text(), 'Efecty')]/ancestor::div[contains(@class, 'row')]"));

    public static Target EFECTY_PAYMENT_BOX = Target
            .the("the efecty payment box")
            .located(By.xpath("//select[@id = 'offline_payment_method']"));

    public static Target EFECTY_DOCUMENT_BOX = Target
            .the("the efecty document box")
            .located(By.xpath("//select[@id = 'offline_payment_company']"));

    public static Target EFECTY_DOCUMENT_NUMBER = Target
            .the("the document input")
            .located(By.xpath("//input[@id = 'offline_payment_number']"));

    public static Target CARD_NUMBER_INPUT = Target
            .the("the card number input")
            .located(By.xpath("//input[@id = 'cardNumber']"));

    public static Target CARD_NUMBER_NAME = Target
            .the("the card name input")
            .located(By.xpath("//input[@id = 'cardName']"));

    public static Target CARD_MONTH_BOX = Target
            .the("the card month box")
            .located(By.xpath("//select[@id = 'cardMonth']"));

    public static Target CARD_YEAR_BOX = Target
            .the("the card year box")
            .located(By.xpath("//select[@id = 'cardYear']"));

    public static Target CCV_NUMBER_INPUT = Target
            .the("the CCV input")
            .located(By.xpath("//input[@id = 'cardCvv']"));

    public static Target CARD_INSTALLMENT = Target
            .the("the card installment box")
            .located(By.xpath("//select[@id = 'installmentsSelect']"));

    public static Target ID_TYPE_BOX = Target
            .the("the id type box")
            .located(By.xpath("//select[@class = 'card-input__input -select full_wide']"));

    public static Target DOC_NUMBER_FIELD = Target
            .the("the id type options")
            .located(By.xpath("//input[@id = 'docNumber']"));

    public static Target TERMS_CONDITIONS_CHECK_BOX = Target
            .the("the terms and conditions check box")
            .located(By.xpath("(//input[@class = 'input-checkbox'])[1]"));

    public static Target PAY_BUTTON = Target
            .the("the terms and conditions check box")
            .located(By.xpath("//button[@class = 'card-form__button']"));

    public static Target CARD_DIGITS = Target
            .the("the card digits in image")
            .located(By.xpath("//div[@class='card-item__numberItem']"));

}
