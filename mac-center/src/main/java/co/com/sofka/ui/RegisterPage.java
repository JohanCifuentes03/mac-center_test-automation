package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {
    public static Target NAME_INPUT = Target
            .the("the name input")
            .located(By.xpath("//input[@id = 'RegisterForm-FirstName']"));

    public static Target LASTNAME_INPUT = Target
            .the("the last name input")
            .located(By.xpath("//input[@id = 'RegisterForm-LastName']"));

    public static Target EMAIL_INPUT = Target
            .the("the email input")
            .located(By.xpath("//input[@id = 'RegisterForm-email']"));

    public static Target PASSWORD_INPUT = Target
            .the("the password input")
            .located(By.xpath("//input[@id = 'RegisterForm-password']"));

    public static Target PASSWORD_CONFIRM_BTN = Target
            .the("the password confirm button")
            .located(By.xpath("//button[normalize-space()='Crear cuenta']"));

}
