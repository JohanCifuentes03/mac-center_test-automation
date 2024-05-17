package co.com.sofka.stepdefinitions.web;

import co.com.sofka.models.UserFormModel;
import co.com.sofka.questions.LogoutLink;
import co.com.sofka.questions.UserInformationText;
import co.com.sofka.tasks.GoToLogin;
import co.com.sofka.tasks.GoToRegister;
import co.com.sofka.tasks.RegisterAccount;
import co.com.sofka.utils.CreateModel;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class RegisterSD extends WebSetup{
    private final UserFormModel userFormModel = CreateModel.createCartFormModel();

    @When("registers its account using valid credentials")
    public void registersItsAccountUsingValidCredentials() {
        actor.attemptsTo(
                GoToLogin.goToLogin(),
                GoToRegister.goToRegister(),
                RegisterAccount.registerAccount().withTheUser(userFormModel),
                GoToLogin.goToLogin()
        );
    }

    @Then("should be logged in the web page")
    public void shouldBeLoggedInTheWebPage() {
        actor.should(
                seeThat(UserInformationText.userInformationText(), containsString(userFormModel.getName())),
                seeThat(UserInformationText.userInformationText(), containsString(userFormModel.getLastname())),
                seeThat(LogoutLink.logoutLink(), is(true))
        );
    }
}
