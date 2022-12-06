package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By selectMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopTab = By.xpath("//a[text()='Desktops']");
    By desktopsText = By.xpath("//h2[text()='Desktops']");
    By laptopsAndNotebooksTab = By.linkText("Laptops & Notebooks");
    By laptopsAndNotBooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By componentsTab = By.linkText("Components");
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(selectMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(selectMenu);
        }
    }

    public void hoverAndClickOnDesktop() {
        mouseHoverToElementAndClick(desktopTab);
    }

    public String getDesktopsText() {
        return getTextFromElement(desktopsText);
    }

    public void hoverAndClickOnLaptopsAndNotebooksTab() {
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
    }

    public String getLaptopsAndNotBooksText() {
        return getTextFromElement(laptopsAndNotBooksText);
    }

    public void hoverAndClickOnComponents() {
        mouseHoverToElementAndClick(componentsTab);
    }

    public String getComponentsText() {
        return getTextFromElement(componentsText);
    }
}
