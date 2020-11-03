package com.tyeporter.gtranslateselenium.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GTranslateHome {

    private WebDriver driver;

    // =========================================================
    // Web elements
    // =========================================================

    @FindBy(css = "#source")
    private WebElement textInput;

    @FindBy(css = "#tl_list-search-box")
    private WebElement moreLanguagesTextInput;

    @FindBy(css = ".tlid-translation")
    private WebElement translation;

    @FindBy(xpath = "//body/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[2]")
    private WebElement spanishButton;

    @FindBy(css = ".clear > .jfk-button-img")
    private WebElement clearButton;

    @FindBy(xpath = "//body/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]")
    private WebElement languagesButton;

    @FindBy(css = "div.language_list_item.language_list_item_language_name")
    private List<WebElement> languages;

    // =========================================================
    // Constructor
    // =========================================================

    public GTranslateHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // =========================================================
    // Actions
    // =========================================================

    public void typeInTextInput(String input) {
        this.textInput.sendKeys(input);
    }

    public void translateToSpanish() {
        this.spanishButton.click();
    }

    public void translateToPortuguese() {
        this.selectMoreLanguages();
        this.moreLanguagesTextInput.sendKeys("Portuguese", Keys.ENTER);
    }

    public void selectMoreLanguages() {
        this.languagesButton.click();
    }

    public void clearInput() {
        this.clearButton.click();
    }

    // =========================================================
    // Getters
    // =========================================================

    public String getTextInput() {
        return this.textInput.getText();
    }

    public String getTranslation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tlid-translation")));
        return this.translation.getText();
    }

    public String getCurrentURL() {
        return this.driver.getCurrentUrl();
    }

    public List<String> getLanguageList() {
        List<String> list = new ArrayList<>();

        for (WebElement element : this.languages) {
            list.add(element.getText());
            System.out.println(element.getText());
        }

        return list;
    }
    
}
