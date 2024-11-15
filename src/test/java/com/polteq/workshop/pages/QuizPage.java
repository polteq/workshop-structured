package com.polteq.workshop.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.Objects;

/**
 * Represents the Quiz Page for the "How Many Countries Can You Name" quiz.
 * This class provides methods to interact with various elements on the quiz page.
 */
public class QuizPage extends BasePage {
    private final Locator cookieConsent = page.locator("");
    private final Locator startButton = page.locator("");
    private final Locator countries = page.locator("");
    private final Locator countryInput = page.locator("");
    private final Locator modalClose = page.locator("");

    /**
     * Constructs a new instance of the QuizPage class.
     *
     * @param page the Page instance to be used by the QuizPage
     */
    public QuizPage(Page page) {
        super(page);
    }

    /**
     * Navigates the browser to the "How Many Countries Can You Name?" quiz page on JetPunk.
     */
    public void navigateToQuizPage() {
        page.navigate("https://www.jetpunk.com/quizzes/how-many-countries-can-you-name");
    }

    /**
     * Clicks the cookie consent button.
     * This method interacts with the cookie consent element on the page to
     * accept the usage of cookies, enabling further interactions with the website.
     */
    public void acceptCookieConsent() {
    }

    /**
     * Initiates the quiz by simulating a click on the start button.
     */
    public void startQuiz() {
    }

    /**
     * Fills in the specified country name into the country input box on the quiz page.
     *
     * @param country the name of the country to be entered into the input box.
     */
    public void fillInCountry(String country) {
    }

    /**
     * Retrieves a list of all country names available on the quiz page.
     *
     * @return a list of country names as strings, with each name trimmed of leading and trailing whitespace
     */
    public List<String> getCountryList() {
        return null; // <-- Change this to the real return value
    }

    /**
     * Checks if the specified country is marked as correct on the quiz page.
     *
     * @param country the name of the country to check
     * @return true if the country is marked as correct, false otherwise
     */
    public boolean isCountryCorrect(String country) {
        return false; // <-- Change this to the real return value
    }

    /**
     * Closes the open modal by clicking on the close button.
     */
    public void closeModal() {
    }
}
