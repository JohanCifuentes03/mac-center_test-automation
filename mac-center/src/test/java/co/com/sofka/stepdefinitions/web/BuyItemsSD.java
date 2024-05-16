package co.com.sofka.stepdefinitions.web;

import co.com.sofka.config.WebUrl;
import co.com.sofka.models.CartFormModel;
import co.com.sofka.models.DebitCardModel;
import co.com.sofka.tasks.*;
import co.com.sofka.utils.CreateModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

public class BuyItemsSD extends WebSetup {
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
        actor.attemptsTo(
                OpenCart.openCart(),
                ConfirmCart.confirmCart()
        );
    }

    @When("confirms their credentials using bbva payment method")
    public void confirmsTheirCredentialsUsingBbvaPaymentMethod() {
        CartFormModel cartFormModel = CreateModel.createCartFormModel();
        DebitCardModel debitCardModel = CreateModel.createDebitCardNumber();
        actor.attemptsTo(
                FillOutForm.fillOutForm().withTheUser(cartFormModel),
                ContinueToPayment.continueToPayment(),
                FillOutBBVAForm.fillOutBBVAForm().withTheUser(cartFormModel).andTheCard(debitCardModel)
        );
    }

    @Then("should receive a confirmation message indicating a successful purchase")
    public void shouldReceiveAConfirmationMessageIndicatingASuccessfulPurchase() {

    }

}
