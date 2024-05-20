package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;


public class MainPage extends PageObject {
    public static Target SEARCH_INPUT = Target.the("the search box").located(By.xpath("//form[@id='nosubmit_form2']//input"));
    public static Target LOGIN_ICON = Target.the("the register icon").located(By.xpath("(//*[@class='icon icon-account'])[2]"));
    public static Target BANNER_PIVOT = Target.the("the banner").located(By.xpath("//div[@id='lob_stripe_slider_box']"));

}
