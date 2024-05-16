package co.com.sofka.ui;

import lombok.Getter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


@Getter
public class FormPage extends PageObject {

    public static Target EMAIL_FIELD = Target
            .the("the email field")
            .located(By.xpath("//input[@id = 'checkout_email_or_phone']"));

    public static Target ID_BOX = Target
            .the("the id box")
            .located(By.xpath("//select[@id = 'dropdown']"));

    public static Target ID_OPTIONS = Target
            .the("the id options")
            .located(By.xpath("//select[@id = 'dropdown']/option"));

    public static Target ID_INPUT = Target
            .the("the id field")
            .located(By.xpath("//input[@id = 'checkoutid']"));

    public static Target NAME_INPUT = Target
            .the("the name field")
            .located(By.xpath("//input[@id = 'checkout_shipping_address_first_name']"));

    public static Target LASTNAME_INPUT = Target
            .the("the lastname field")
            .located(By.xpath("//input[@id = 'checkout_shipping_address_last_name']"));

    public static Target ADDRESS_INPUT = Target
            .the("the address field")
            .located(By.xpath("//input[@id = 'checkout_shipping_address_address1']"));

    public static Target PHONE_INPUT = Target
            .the("the phone field")
            .located(By.xpath("//input[@id = 'checkout_shipping_address_phone']"));

    public static Target DEPARTMENT_BOX = Target
            .the("the department box")
            .located(By.xpath("//select[@id = 'checkout_contact_information_custom_province']"));

    public static Target DEPARTMENT_OPTIONS = Target
            .the("the department option")
            .located(By.xpath("//select[@id = 'checkout_contact_information_custom_province']/option"));

    public static Target CITY_BOX = Target
            .the("the city box")
            .located(By.xpath("//select[@id = 'checkout_contact_information_custom_city']"));

    public static Target CITY_OPTIONS = Target
            .the("the city box")
            .located(By.xpath("//select[@id = 'checkout_contact_information_custom_city']/option"));

    public static Target CONTINUE_BTN = Target
            .the("the continue button")
            .located(By.xpath("//button[@id = 'continue_button']"));
}
