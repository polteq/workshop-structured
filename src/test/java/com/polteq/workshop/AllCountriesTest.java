package com.polteq.workshop;

import com.microsoft.playwright.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllCountriesTest extends CountriesOfTheWorldScenario {

    /**
     * Tests the functionality of naming all countries in the JetPunk country quiz.
     * <p>
     * This test automates the process of opening the browser, navigating to the JetPunk
     * "How many countries can you name?" quiz, and verifying that all countries can be
     * correctly entered and marked as correct answers.
     * <p>
     * Steps:
     * 1. Arrange: Set up the Playwright environment and browser, and navigate to the quiz page.
     * 2. Act: Accept cookie consent, start the quiz, retrieve all country names, and enter each
     * country into the answer box. Close any popups that appear.
     * 3. Assert: Verify that all entered countries are marked as correct.
     */
    @Test
    @DisplayName("Test all Countries of the World")
    public void allCountriesTest() {
        // +-----------------------------------------------------------------------------------------------------------+
        // | Arrange
        // +-----------------------------------------------------------------------------------------------------------+

        // Setup Playwright
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // Initialize browser
        page.setViewportSize(1920, 1080);
        page.navigate("https://www.jetpunk.com/quizzes/how-many-countries-can-you-name");

        // +-----------------------------------------------------------------------------------------------------------+
        // | Act
        // +-----------------------------------------------------------------------------------------------------------+

        // Click on the cookie consent button
        page.locator("[aria-label='Consent']").click();
        // Click on the start button to start the game
        page.locator("#start-button").click();

        // Retrieve all countries
        List<String> countries = page.locator(".gxh").all().stream()
                .map(locator -> locator.textContent().trim())
                .toList();

        // For every country fill in the country in the answer box
        for (String country : countries) {
            page.locator("#txt-answer-box").fill(country);
        }

        // Close the first popup
        page.locator("[aria-label='Close']").click();
        // Close the second popup
        page.locator("[aria-label='Close']").click();

        // +-----------------------------------------------------------------------------------------------------------+
        // | Assert
        // +-----------------------------------------------------------------------------------------------------------+

        // Check if all countries are marked as correct in the tables
        SoftAssertions softAssertions = new SoftAssertions();
        for (String country : countries) {
            Locator elCountry = page.locator("//td[contains(@class, 'correct') and .= '%s']".formatted(country));
            softAssertions.assertThat(elCountry.isVisible())
                    .as("Country " + country + "should be in the list")
                    .isTrue();
        }
        softAssertions.assertAll();

        // +-----------------------------------------------------------------------------------------------------------+
        // | Cleanup
        // +-----------------------------------------------------------------------------------------------------------+

        // Cleanup Playwright
        page.close();
        browser.close();
        playwright.close();
    }
}
