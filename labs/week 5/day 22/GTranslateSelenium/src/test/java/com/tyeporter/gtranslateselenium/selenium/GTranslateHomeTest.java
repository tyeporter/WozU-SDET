package com.tyeporter.gtranslateselenium.selenium;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GTranslateHomeTest {
    WebDriver driver;
    GTranslateHome homePage;
    private final String BASE_ENDPOINT = "https://translate.google.com/";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/tyeporter/selenium/chromedriver");
        ChromeOptions options = new ChromeOptions().setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
        driver = new ChromeDriver(options);
        driver.navigate().to(BASE_ENDPOINT);
        homePage = new GTranslateHome(driver);
    }
    
    @Test
    public void test_TypeInNoteInput() throws Exception {
        homePage.typeInTextInput("Hello");

        String expected = "Hello";

        assertEquals(expected, homePage.getTranslation());
    }

    @Test
    public void test_TranslateToSpanish() throws Exception {
        homePage.typeInTextInput("Hello");
        homePage.translateToSpanish();

        String expected = "Hola";

        assertEquals(expected, homePage.getTranslation());
    }

    @Test
    public void test_TranslateToPortuguese() throws Exception {
        homePage.typeInTextInput("Hello");
        homePage.translateToPortuguese();

        String expected = "Olá";

        assertEquals(expected, homePage.getTranslation());
    }

    @Test
    public void test_LanguageList() {
        homePage.selectMoreLanguages();

        assertThat(homePage.getLanguageList(), hasItems("English", "Hebrew", "Yoruba"));
    }

    @Test
    public void test_ClearInput() throws Exception {
        homePage.typeInTextInput("Hello");
        homePage.clearInput();

        String expected = "";

        assertEquals(expected, homePage.getTextInput());
    }
}
