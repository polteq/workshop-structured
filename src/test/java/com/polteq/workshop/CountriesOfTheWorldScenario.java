package com.polteq.workshop;

import com.microsoft.playwright.*;
import com.polteq.workshop.lib.BrowserFactory;
import com.polteq.workshop.lib.BrowserName;
import com.polteq.workshop.pages.QuizPage;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountriesOfTheWorldScenario {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    protected Page page;
    protected QuizPage quizPage;

    @BeforeAll
    public void beforeAllTests() {
        // Write your code here
    }

    @BeforeEach
    public void setUp() {
        // Write your code here
        // quizPage = new QuizPage(page); // <-- Uncomment when you have written the correct code
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        // Write your code here
    }

    @AfterAll
    public void afterAllTests() {
        // Write your code here
    }
}
