package com.williamhill.games.pages;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.WebPage;
import static com.github.webdriverextensions.Bot.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Bean on 14/04/2017.
 */
public class GamesMenu extends WebPage {

    public GamesMenu(){
        PageFactory.initElements(WebDriverExtensionsContext.getDriver(),this);
    }

    @FindBy(css = "a[href*='#!/lobby/az']")
    WebElement linkAZ;

    @Override
    public void open(Object... objects) {
        open("https://games.williamhill.com/#!/lobby/az");
    }

    @Override
    public void assertIsOpen(Object... objects) throws AssertionError {

    }

    public void goToAZ(){
        click(linkAZ);
    }

}
