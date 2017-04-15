package com.williamhill.games.stepdefs;

import com.williamhill.games.pages.AZPage;
import com.williamhill.games.pages.GamesMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by Bean on 14/04/2017.
 */
public class AZStepDefs {

    GamesMenu gamesMenu = new GamesMenu();
    AZPage azPage = new AZPage();

    @Then("^I can count all A-Z games$")
    public void count_all_games() throws InterruptedException {
        gamesMenu.goToAZ();
        azPage.logCountGames();
    }

    @And("^log the names$")
    public void log_all_game_names(){
        azPage.logGames();
    }
}
