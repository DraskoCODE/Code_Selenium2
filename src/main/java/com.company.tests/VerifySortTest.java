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
        productsPage.selectLowToHigh();

        //productsPage.selectValue("Price (low to high)");
        //productsPage.closePage();
        //System.out.println(productsPage.returnSelectedOption());
        Assert.assertEquals(productsPage.isListSortedFromLowToHighByPrice(), true, "List is not sorted by low to high");
        System.out.println("TEST");

    }

}
