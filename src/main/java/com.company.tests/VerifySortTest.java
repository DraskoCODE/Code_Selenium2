package com.company.tests;

import com.company.pages.LoginPage;
import com.company.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySortTest extends BaseTest {

    @Test
    public void VerifySortByLowToHigh() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();;
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        //productsPage.selectLowToHigh();

        productsPage.selectValue("Price (low to high)");
        //productsPage.closePage();
        //System.out.println(productsPage.returnSelectedOption());
        Assert.assertEquals(productsPage.isListSortedFromLowToHighByPrice(), true, "List is not sorted by low to high");
        System.out.println("TEST");

    }

    @Test
    public void VerifySortByHighToLow() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();;
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        //productsPage.selectLowToHigh();

        productsPage.selectValue("Price (high to low)");
        //productsPage.closePage();
        //System.out.println(productsPage.returnSelectedOption());
        Assert.assertEquals(productsPage.isListSortedFromHighToLowByPrice(), true, "List is not sorted by high to low");
        System.out.println("TEST");

    }

    @Test
    public void VerifySortByAtoZ() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();;
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        //productsPage.selectLowToHigh();

        productsPage.selectValue("Name (A to Z)");
        //productsPage.closePage();
        System.out.println(productsPage.returnSelectedOption());
        Assert.assertEquals(productsPage.isListSortedFromAtoZbyName(), true, "List is not sorted by nama, from A to Z");
        System.out.println("TEST");

    }

    @Test
    public void VerifySortByZtoA() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();;
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        //productsPage.selectLowToHigh();

        productsPage.selectValue("Name (Z to A)");
        //productsPage.closePage();
        //System.out.println(productsPage.returnSelectedOption());
        Assert.assertEquals(productsPage.isListSortedFromZtoAbyName(), true, "List is not sorted by nama, from Z to A");
        System.out.println("TEST");

    }

}
