package com.williamhill.games.stepdefs;

import com.williamhill.games.pages.AZPage;
import com.williamhill.games.pages.GamesMenu;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Bean on 14/04/2017.
 */
public class AZStepDefs {

    private Logger logger = LoggerFactory.getLogger(AZStepDefs.class);

    GamesMenu gamesMenu = new GamesMenu();
    AZPage azPage = new AZPage();

    @Then("^I can count all A-Z games$")
    public void count_all_games() throws InterruptedException {
        gamesMenu.goToAZ();
        logger.info("Number of games: {}", azPage.countGames());
    }
}
