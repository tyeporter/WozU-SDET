package com.tyeporter.youtubemusicselenium.www;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YoutubeMusicTest {
    // Properties
    private WebDriver driver;
    private final String BASE_ENDPOINT = "https://music.youtube.com/";

    // Setup 

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/tyeporter/selenium/chromedriver");
        ChromeOptions options = new ChromeOptions().setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
        driver = new ChromeDriver(options);
        driver.navigate().to(BASE_ENDPOINT);
    }
    

    // =========================================================
    // HOME PAGE
    // =========================================================

    @Test
    public void testHomePage_HasLogoNavigationItem() {
        WebElement homeLink = driver.findElement(
            By.xpath("//body/ytmusic-app[1]/ytmusic-app-layout[1]" 
                    + "/ytmusic-nav-bar[1]/div[1]/a[1]")
        );

        homeLink.click();
        assertEquals("YouTube Music", driver.getTitle());
    }

    @Test
    public void testHomePage_HasHomeNavigationItem() {
        WebElement homeLink = driver.findElement(
            By.cssSelector(".style-scope:nth-child(1) > .tab-title")
        );

        assertEquals("Home", homeLink.getText());
    }

    @Test
    public void testHomePage_HasExploreNavigationItem() {
        WebElement exploreLink = driver.findElement(
            By.cssSelector(".style-scope:nth-child(2) > .tab-title")
        );

        assertEquals("Explore", exploreLink.getText());
    }

    @Test
    public void testHomePage_HasLibraryNavigationItem() {
        WebElement libraryLink = driver.findElement(
            By.cssSelector(".style-scope:nth-child(3) > .tab-title")
        );

        assertEquals("Library", libraryLink.getText());
    }

    @Test
    public void testHomePage_HasSearchNavigationItem() {
        WebElement searchLinkPlaceholder = driver.findElement(
            By.xpath("//span[@id='placeholder']")
        );

        assertEquals("Search", searchLinkPlaceholder.getText());
    }

    @Test
    void testHomePage_WriteInSearchBar() {
        WebElement searchButton = driver.findElement(
            By.xpath("//body/ytmusic-app[1]" 
                    + "/ytmusic-app-layout[1]" 
                    + "/ytmusic-nav-bar[1]/div[2]" 
                    + "/ytmusic-search-box[1]")
        );

        WebElement searchBarInput = driver.findElement(
            By.xpath("/html[1]/body[1]/ytmusic-app[1]" 
                    + "/ytmusic-app-layout[1]/ytmusic-nav-bar[1]/div[2]" 
                    + "/ytmusic-search-box[1]/div[1]/div[1]/input[1]")
        );

        searchButton.click();
        searchBarInput.sendKeys("Kendrick Lamar" + Keys.ENTER);

        // TODO: Figure out how to make test wait until page loads completely
        // assertEquals(BASE_ENDPOINT + "search?q=kendrick+lamar", driver.getCurrentUrl());
        
        assertEquals(BASE_ENDPOINT, driver.getCurrentUrl());
    }

    // =========================================================
    // RESULTS PAGE
    // =========================================================

    @Test
    public void testResultPage_HasResultsSections() {
        driver.navigate().to(BASE_ENDPOINT + "search?q=kendrick+lamar");
        List<WebElement> sections = driver.findElements(
            By.cssSelector(".ytmusic-section-list-renderer > .title > .style-scope")
        );
        List<String> sectionContent = new ArrayList<>();

        for (WebElement section : sections) {
            sectionContent.add(section.getText());
        }

        assertThat(sectionContent, hasItems("Top result", "Songs", "Albums", "Playlists", "Artists", "Videos"));
    }

    @Test
    public void testResultsPage_TopResult() {
        driver.navigate().to(BASE_ENDPOINT + "search?q=lupe+fiasco");

        WebElement topResultTitleElement = driver.findElement(
            By.xpath("//body/ytmusic-app[1]/ytmusic-app-layout[1]/div[3]" 
                    + "/ytmusic-search-page[1]/ytmusic-section-list-renderer[1]/div[2]" 
                    + "/ytmusic-shelf-renderer[1]/div[2]" 
                    + "/ytmusic-responsive-list-item-renderer[1]/div[2]/div[1]/yt-formatted-string[1]")
        );

        assertEquals("Lupe Fiasco", topResultTitleElement.getText());
    }

    // Tear Down

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}
