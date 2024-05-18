package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountPage extends PageObject {
    public static Target NAME_LABEL = Target.the("the name label").located(By.xpath("//p[contains(.,'Colombia')]"));
    public static Target LOGOUT_ACCOUNT_LINK = Target.the("the logout link").located(By.xpath("//p[contains(.,'Colombia')]"));
}
