package com.williamhill.games.runner;

import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.internal.junitrunner.DriverPathLoader;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Bean on 12/04/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty","html:format"},
        features = "src/test/resources/features",glue={"classpath:com/williamhill/games/stepdefs"})

public class RunTest {

    static {
        // invoke the framework method to set the driver paths as expected.
        DriverPathLoader.loadDriverPaths(null);
    }

    /**
     * working browsers:
     * Chrome
     * Firefox
     * PhantomJS
     */
    @BeforeClass
    public static void setUp(){
        WebDriverExtensionsContext.setDriver(new ChromeDriver());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Bot.driver().quit();
        WebDriverExtensionsContext.removeDriver();
    }
}
