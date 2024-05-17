package co.com.sofka.stepdefinitions.web;

import java.util.List;
import co.com.sofka.config.WebUrl;
import co.com.sofka.models.UserFormModel;
import co.com.sofka.models.DebitCardModel;
import co.com.sofka.questions.CardNumber;
import co.com.sofka.tasks.*;
import co.com.sofka.utils.CreateModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static co.com.sofka.questions.PayButtonEnabled.paymentButtonEnabled;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class BuyItemsSD extends WebSetup {
    private final DebitCardModel debitCardModel = CreateModel.createDebitCardNumber();
    private final UserFormModel userFormModel = CreateModel.createCartFormModel();

    @Given("the user is on the mac-center.com platform using {string}")
    public void theUserIsOnTheMacCenterComPlatformUsing(String webDriver) {
        actorSetupTheBrowser(webDriver);
        givenThat(actor).wasAbleTo(
                OpenMain.openMainPage().withTheUrl(WebUrl.MAC_CENTER_LINK)
        );
    }


    @When("adds the following items to the cart")
    public void addsTheFollowingItemsToTheCart(List<String> items) {
        items.forEach(itemName -> actor.attemptsTo(
                SearchItem.searchItem().withName(itemName),
                AddItemToCart.addItemToCart()
        ));
    }

    @And("goes to the cart")
    public void goesToTheCart() {
        actor.attemptsTo(
                OpenCart.openCart(),
                ConfirmCart.confirmCart()
        );
    }

    @When("confirms their credentials using bbva payment method")
    public void confirmsTheirCredentialsUsingBbvaPaymentMethod() {

        actor.attemptsTo(
                FillOutForm.fillOutForm().withTheUser(userFormModel),
                ContinueToPayment.continueToPayment(),
                SelectBbvaOption.selectBbvaOption(),
                FillOutBBVAForm.fillOutBBVAForm().withTheUser(userFormModel).andTheCard(debitCardModel)
        );
    }

    @Then("should receive a confirmation message indicating a successful purchase")
    public void shouldReceiveAConfirmationMessageIndicatingASuccessfulPurchase() {
        int last = debitCardModel.getNumber().length() - 1;

        actor.should(
                seeThat(paymentButtonEnabled(), is(true)),
                seeThat(CardNumber.allDigits(),
                        containsString(debitCardModel.getNumber().substring(0, 4))),
                seeThat(CardNumber.allDigits(),
                        containsString(debitCardModel.getNumber().substring(last - 3 )))
        );
    }


}
