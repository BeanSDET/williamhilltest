package com.williamhill.games.pages;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.WebPage;
import static com.github.webdriverextensions.Bot.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Predicate;

/**
 * Created by Bean on 13/04/2017.
 */
public class HeaderMenu extends WebPage {

    public HeaderMenu(){
        PageFactory.initElements(WebDriverExtensionsContext.getDriver(),this);
    }

    @FindBy(css = "a[href*='#!/action/login']")
    WebElement login;

    @FindBy(css = "[data-ng-if='session.loggedin']")
    WebElement loggedIn;

    public void clickLogin(){
        login.click();
    }

    public void waitForLogIn(){
        waitUntil(new Predicate<WebDriver>() {
            @Override
            public boolean test(WebDriver webDriver) {
                return loggedIn.isEnabled();
            }
        });
    }

    @Override
    public void open(Object... objects) {

    }

    @Override
    public void assertIsOpen(Object... objects) throws AssertionError {

    }
}
