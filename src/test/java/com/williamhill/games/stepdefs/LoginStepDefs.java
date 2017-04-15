package com.williamhill.games.stepdefs;


import com.williamhill.games.pages.HeaderMenu;
import com.williamhill.games.pages.HomePage;
import com.williamhill.games.pages.LoginPopUp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


/**
 * Created by Bean on 12/04/2017.
 */
public class LoginStepDefs {

    private HomePage homePage = new HomePage();
    private HeaderMenu headerMenu = new HeaderMenu();
    private LoginPopUp loginPopUp = new LoginPopUp();

        @Given("^I navigate to the home page$")
        public void load_home_page(){
            homePage.open();
            homePage.logSiteVersion();
            homePage.logStackCookieValue();
        }

        @And("^I login to the member area$")
        public void login() throws InterruptedException {
            headerMenu.clickLogin();
            loginPopUp.completeLoginFromProperties();
            headerMenu.waitForLogIn();
        }

}
