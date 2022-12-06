package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {
    By showAllDesktops = By.linkText("Show All Desktops");
    By sortByZToA = By.id("input-sort");
    By beforeSortedProducts = By.xpath("//h4/a");

    By afterSortedProducts = By.xpath("//h4/a");

    By sortByAToZ = By.id("input-sort");
    By clickOnHpLaptop = By.xpath("//a[contains(text(),'HP LP3065')]");
    By hpLaptopText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By clearQuantity = By.name("quantity");
    By enterQuantity = By.name("quantity");
    By addToCartButton = By.id("button-cart");
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By clickShoppingCart = By.xpath("//a[text()='shopping cart']");
    By shoppingCartText = By.xpath("//div[@id='content']//h1");
    By productNameHPLP3065 = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By productModel = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");

    By currency = By.xpath("//span[text()='Currency']");
    By sterlingPound = By.xpath("//button[contains(text(),'£ Pound Sterling')]");
    By total = By.xpath("//tbody/tr[1]/td[6]");

    public void clickOnShowAllDesktops() {
        clickOnElement(showAllDesktops);
    }

    public String sortByNameZToA() {
        List<WebElement> products = driver.findElements(beforeSortedProducts);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(sortByZToA, "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(afterSortedProducts);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        return null;
    }


    public void sortByNameAToZ() {
        selectByVisibleTextFromDropDown(sortByAToZ, "Name (A - Z)");
    }

    public void clickOnHpLp3065() {
        clickOnElement(clickOnHpLaptop);
    }

    public String getHpLaptopText() {
        return getTextFromElement(hpLaptopText);
    }

    public void deliveryDate() {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clearQuantityField() {
        driver.findElement(clearQuantity).clear();
    }

    public void changeTheQuantity() {
        sendTextToElements(enterQuantity, "1");
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public String getSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartText() {
        clickOnElement(clickShoppingCart);
    }

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        return getTextFromElement(productNameHPLP3065);
    }

    public String getDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    public String getProductModelName() {
        return getTextFromElement(productModel);
    }

    public void clickOnCurrency() {
        clickOnElement(currency);
    }

    public void clickOnSterlingPound() {
        clickOnElement(sterlingPound);
    }

    public String getTotal() {
        return getTextFromElement(total);
    }

}