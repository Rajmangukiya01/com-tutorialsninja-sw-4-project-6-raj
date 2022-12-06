package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopsPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        homePage.hoverAndClickOnDesktop();
        desktopsPage.clickOnShowAllDesktops();
        desktopsPage.sortByNameZToA();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        homePage.hoverAndClickOnDesktop();
        desktopsPage.clickOnShowAllDesktops();
        desktopsPage.sortByNameAToZ();
        desktopsPage.clickOnHpLp3065();
        String expectedText = "HP LP3065";
        Assert.assertEquals(desktopsPage.getHpLaptopText(), expectedText, "HP LP3065 is not displayed");
        desktopsPage.deliveryDate();
        desktopsPage.clearQuantityField();
        desktopsPage.changeTheQuantity();
        desktopsPage.clickOnAddToCartButton();
        String expectedSuccessText = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals(desktopsPage.getSuccessMessage(), expectedSuccessText, "Success message is not displayed");
        Thread.sleep(5000);
        desktopsPage.clickOnShoppingCartText();
        String expectedMessage = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(desktopsPage.getShoppingCartText(), expectedMessage, "Shopping cart is not displayed");
        String expectedProductName = "HP LP3065";
        Assert.assertEquals(desktopsPage.getProductName(), expectedProductName, "HP LP3065 is not displayed");
        Assert.assertEquals(desktopsPage.getDeliveryDate(),"Delivery Date: 2023-11-30","Delivery date not displayed");
        String expectedModelName = "Product 21";
        Assert.assertEquals(desktopsPage.getProductModelName(), expectedModelName, "Product 21 is not displayed");
        desktopsPage.clickOnCurrency();
        desktopsPage.clickOnSterlingPound();
        String expectedTotal = "£74.73";
        Assert.assertEquals(desktopsPage.getTotal(), expectedTotal, "Total is not displayed");
    }
}
