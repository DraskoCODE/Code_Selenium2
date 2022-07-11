package com.company.tests;

import com.company.pages.CartPage;
import com.company.pages.HomePage;
import com.company.pages.ProductDetailsPage;
import com.company.provider.ProductNameProvider;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class VerifyAddItemTests extends BaseTest {

    @Test(dataProvider = "ProductNameProvider", dataProviderClass = ProductNameProvider.class)
    public void VerifyAddItem(String productName) {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.waitPageToBeOpened();

        CartPage cartPage = homePage.openCart();
        cartPage.waitPageToBeRendered();
        HashMap<String, Integer> expectedTable = cartPage.getTableDataByTitle();
        homePage = cartPage.openHome();
        homePage.waitPageToBeOpened();

        ProductDetailsPage productDetailsPage = homePage.addItemByName(productName);
        productDetailsPage.waitPageToBeOpened();
        productDetailsPage.addToCart();
        productDetailsPage.waitAlertToBeOpened();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        cartPage = productDetailsPage.openCart();
        cartPage.waitPageToBeRendered();
        HashMap<String, Integer> actualTable = cartPage.getTableDataByTitle();

        if(!expectedTable.containsKey(productName)) {
            Assert.assertEquals(actualTable.get(productName), 1);
        }
        else {
            Assert.assertEquals(actualTable.get(productName), expectedTable.get(productName) + 1);
        }

    }

    @Test(dataProvider = "ProductNamesProvider", dataProviderClass = ProductNameProvider.class)
    public void VerifyDeleteItems(String productNames) {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.waitPageToBeOpened();

        ProductDetailsPage productDetailsPage = null;
        String[] parts = productNames.split(",");
        for(int i = 0; i < parts.length; i++) {
            System.out.println(homePage.getProductPriceByName(parts[i]));
            productDetailsPage = homePage.addItemByName(parts[i]);
            productDetailsPage.waitPageToBeOpened();
            productDetailsPage.addToCart();
            productDetailsPage.waitAlertToBeOpened();

            Alert alert = driver.switchTo().alert();
            alert.accept();

            productDetailsPage.openHome();
            homePage.waitPageToBeOpened();

        }

        CartPage cartPage = homePage.openCart();
        cartPage.waitPageToBeRendered();

        //System.out.println(cartPage.getTotalPrice());
        HashMap<String, Integer> map = cartPage.getTableDataByTitle();
        for(int i = 0; i < parts.length; i++) {
            cartPage.deleteRowByTitle(parts[i]);
        }
        //cartPage.deleteRowByTitle("Sony xperia z5");
        //cartPage.deleteRowByTitle("Nexus 6");
        System.out.println("TEST");

    }

    @Test(dataProvider = "ProductNamesProvider", dataProviderClass = ProductNameProvider.class)
    public void VerifyAddItems(String productNames) {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.waitPageToBeOpened();

        ProductDetailsPage productDetailsPage = null;
        String[] parts = productNames.split(",");
        for(int i = 0; i < parts.length; i++) {
            System.out.println(homePage.getProductPriceByName(parts[i]));
            productDetailsPage = homePage.addItemByName(parts[i]);
            productDetailsPage.waitPageToBeOpened();


            productDetailsPage.addToCart();
            productDetailsPage.waitAlertToBeOpened();



            Alert alert = driver.switchTo().alert();
            alert.accept();

            productDetailsPage.openHome();
            homePage.waitPageToBeOpened();


        }

        CartPage cartPage = homePage.openCart();
        cartPage.waitPageToBeRendered();
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cartPage.getTotalPrice());
        HashMap<String, Integer> map = cartPage.getTableDataByTitle();
        cartPage.deleteRowByTitle("Sony xperia z5");
        cartPage.deleteRowByTitle("Nexus 6");

        /*ProductDetailsPage productDetailsPage = homePage.addItemByName(productName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //ProductDetailsPage productDetailsPage = homePage.addItemByName("Sony vaio i5");
        productDetailsPage.addToCart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert = driver.switchTo().alert();
        alert.accept();
        productDetailsPage.openCart();*/
        //homePage.openCart();
        //driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
        System.out.println("dada");
        /*Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage);
        alert.accept();// Print Alert Message*/

    }

}
