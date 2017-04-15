package com.williamhill.games.pages;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.github.webdriverextensions.Bot.*;

/**
 * Created by Bean on 13/04/2017.
 */
public class LoginPopUp extends WebPage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPopUp.class);

    public LoginPopUp(){
        PageFactory.initElements(WebDriverExtensionsContext.getDriver(), this);
    }

    @Override
    public void open(Object... objects) {

    }

    @Override
    public void assertIsOpen(Object... objects) throws AssertionError {

    }

    @FindBy(className = "wf-quicklogin")
    WebElement loginPopup;

    @FindBy(css = "[data-ng-controller='wfQuickLoginController']")
    WebElement loginController;

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(css = "[type=submit]")
    WebElement loginButton;


    public void waitForLoginToDisplay(){
       logger.debug("waiting for login popup to display");
       waitForElementToDisplay(loginPopup);
       logger.debug("login popup displayed");
    }

    public void enterUserName(String username){
        type(username, this.username);
    }

    public void enterPassword(String password){
        type(password, this.password);
    }

    private Map<String,String> getSystemProperies(){
        return new HashMap(System.getProperties());
    }

    private String getUsernameFromProperties() {
        if(getSystemProperies().containsKey("username")){
            return System.getProperty("username");
        } else {
            logger.error("username not set " +
                    "please pass at runtime via " +
                    "-Dusername=username");
            throw new NullPointerException();
        }
    }

    private String getPasswordFromProperties() {
        if(getSystemProperies().containsKey("password")){
            return System.getProperty("password");
        } else {
            logger.error("password not set " +
                    "please pass at runtime via " +
                    "-Dpassword=password");
            throw new NullPointerException();
        }
    }

    public void clickLogin(){
        click(loginButton);
    }


    public void completeLoginFromProperties() throws InterruptedException {
        waitForLoginToDisplay();
        enterUserName(getUsernameFromProperties());
        enterPassword(getPasswordFromProperties());
        clickLogin();
    }
}
