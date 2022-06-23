package com.company.tests;

import com.company.pages.LoginPage;
import com.company.pages.ProductsPage;
import com.company.provider.UserNameProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLogin {

    @Test(dataProvider = "UserNameProvider", dataProviderClass = UserNameProvider.class)
    public void VerifyLoginWithValidCredentialsWithParams(String userName) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage();
        loginPage.setDriver(driver);
        loginPage.setUrl("https://www.saucedemo.com/");

        loginPage.openPage();;
        loginPage.setUserName(userName);
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        ProductsPage productsPage = new ProductsPage();
        productsPage.setDriver(driver);
        productsPage.setUrl("https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        productsPage.closePage();

    }

    @Test
    public void VerifyLoginWithValidCredentials() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage();
        loginPage.setDriver(driver);
        loginPage.setUrl("https://www.saucedemo.com/");

        loginPage.openPage();;
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        ProductsPage productsPage = new ProductsPage();
        productsPage.setDriver(driver);
        productsPage.setUrl("https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        productsPage.closePage();

    }

    @Test
    public void VerifyLoginWithInValidCredentials() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage();
        loginPage.setDriver(driver);
        loginPage.setUrl("https://www.saucedemo.com/");

        loginPage.openPage();;
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_saucee");
        loginPage.clickOnLogin();

        ProductsPage productsPage = new ProductsPage();
        productsPage.setDriver(driver);
        productsPage.setUrl("https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(productsPage.isDisplayed(), false, "Login failed");
        productsPage.closePage();

    }


}