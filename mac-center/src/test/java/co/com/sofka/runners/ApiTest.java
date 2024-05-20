package co.com.sofka.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"co.com.sofka.stepdefinitions",
                "co.com.sofka.hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@service"
)
public class ApiTest {
}
