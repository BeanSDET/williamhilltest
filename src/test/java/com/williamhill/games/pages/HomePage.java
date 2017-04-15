package com.williamhill.games.pages;

import static com.github.webdriverextensions.Bot.*;
import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bean on 12/04/2017.
 */

public class HomePage extends WebPage {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(css = "[rel=stylesheet]")
    WebElement stylesheet;

    public HomePage(){
        PageFactory.initElements(WebDriverExtensionsContext.getDriver(),this);
    }

    @Override
    public void open(Object... objects) {
        open("https://games.williamhill.com");
    }

    @Override
    public void assertIsOpen(Object... objects) throws AssertionError {

    }

    public void logSiteVersion(){
        Pattern versionPattern = Pattern.compile("\\d+.\\d+.\\d+");
        String href = stylesheet.getAttribute("href");
        Matcher m = versionPattern.matcher(href);
        if(m.find()){
            logger.info("Site version: {}", m.group());
        } else {
            logger.warn("Site version could not be determined");
        }
    }

    public void logStackCookieValue(){
        try {
           Cookie stackCookie = driver().manage().getCookieNamed("STACK");
            logger.info("STACK Cookie Value: {}", stackCookie.getValue());
        } catch (NullPointerException e) {
            logger.warn("STACK Cookie Value not found");
        }
    }
}
