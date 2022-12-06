package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.hoverAndClickOnDesktop();
        homePage.selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        Assert.assertEquals(homePage.getDesktopsText(),expectedText,"Desktops text is not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.hoverAndClickOnLaptopsAndNotebooksTab();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedText = "Laptops & Notebooks";
        Assert.assertEquals(homePage.getLaptopsAndNotBooksText(),expectedText,"Laptops & Notebooks is not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homePage.hoverAndClickOnComponents();
        homePage.selectMenu("Show All Components");
        String expectedText = "Components";
        Assert.assertEquals(homePage.getComponentsText(),expectedText,"Components is not displayed");
    }
}
