package com.williamhill.games.pages;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.WebPage;
import static com.github.webdriverextensions.Bot.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;

import static com.github.webdriverextensions.Bot.assertCurrentUrlEndsWith;
import static com.github.webdriverextensions.Bot.driver;
import static com.github.webdriverextensions.Bot.waitFor;

/**
 * Created by Bean on 14/04/2017.
 */
public class AZPage extends WebPage {

    private static final Logger logger = LoggerFactory.getLogger(AZPage.class);

    public AZPage(){
        PageFactory.initElements(WebDriverExtensionsContext.getDriver(), this);
    }

    @FindBy(css = "[data-wf-game-tile=game]")
    List<WebElement> games;

    @Override
    public void open(Object... objects) {

    }

    @Override
    public void assertIsOpen(Object... objects) throws AssertionError {
        assertCurrentUrlEndsWith("#!/lobby/az");
    }

    public int countGames() throws InterruptedException {
        //TODO: implement wait properly, I've tried various JS executors but haven't managed to get it to work
        waitUntil(new Predicate<WebDriver>() {
            @Override
            public boolean test(WebDriver webDriver) {
                return (Boolean) executeJavascript("return document.readyState").equals("complete");
            }
        });

        waitUntil(new Predicate<WebDriver>() {
            @Override
            public boolean test(WebDriver webDriver) {
                int startCount = driver().findElements(By.cssSelector("[data-wf-game-tile=game]")).size();
                logger.debug("start count: {}", startCount);
                waitFor(1);
                int endCount = driver().findElements(By.cssSelector("[data-wf-game-tile=game]")).size();
                logger.debug("end count: {}", endCount);
                return startCount==endCount;
            }
        });
        return games.size();
    }
}
