package co.com.sofka.stepdefinitions.web;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebSetup {
    @Managed
    protected static WebDriver webDriver;

    public static final Actor actor = new Actor("Johan");

    private void setupActor(WebDriver webDriver, String browserType) {
        OnStage.setTheStage(new OnlineCast());
        actor.can(BrowseTheWeb.with(webDriver));
    }

    protected void actorSetupTheBrowser(String browserType) {
        WebDriver webDriver = getWebDriver(browserType);
        setupActor(webDriver, browserType);
        maximize(webDriver);
    }

    private WebDriver getWebDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                return new ChromeDriver(chromeOptions);
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--inprivate");
                return new EdgeDriver(edgeOptions);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new IllegalArgumentException("Web browser not compatible: " + browserType);
        }
    }

    private void maximize(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }
}
