package com.company.tests;

import com.company.pages.LoginPage;
import com.company.pages.ProductsPage;
import com.company.provider.InvalidUserName;
import com.company.provider.UserNameProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyLoginTest extends BaseTest {


    @Test(dataProvider = "UserNameProvider", dataProviderClass = UserNameProvider.class)
    public void VerifyLoginWithValidCredentialsWithParams(String userName) {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.setDriver(driver);
        //loginPage.setUrl("https://www.saucedemo.com/");

        loginPage.openPage();
        loginPage.setUserName(userName);
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        /*ProductsPage productsPage = new ProductsPage();
        productsPage.setDriver(driver);
        productsPage.setUrl("https://www.saucedemo.com/inventory.html");*/

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        //productsPage.closePage();

    }

    @Test
    public void VerifyLoginWithValidCredentials() {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.setDriver(driver);
        //loginPage.setUrl("https://www.saucedemo.com/");

        loginPage.openPage();;
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        /*ProductsPage productsPage = new ProductsPage();
        productsPage.setDriver(driver);
        productsPage.setUrl("https://www.saucedemo.com/inventory.html");*/

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        //productsPage.closePage();

    }

    @Test(dataProvider = "NonValidUserNameProvider", dataProviderClass = InvalidUserName.class)
    public void VerifyLoginWithInValidCredentials(String userName) {

        //System.setProperty("webdriver.chrome.driver", "C:\Users\comp\Downloads\chromedriver_win32\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        //Implicitni wait
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //loginPage.setDriver(driver);
        //loginPage.setUrl("https://www.saucedemo.com/");

        loginPage.openPage();
        loginPage.setUserName(userName);
        loginPage.setPassword("secret_saucee");
        loginPage.clickOnLogin();

        //driver.findElement(By.className("inventory-container"));
        //Vracanje na default vrednost
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

       /* ProductsPage productsPage = new ProductsPage();
        productsPage.setDriver(driver);
        productsPage.setUrl("https://www.saucedemo.com/inventory.html");*/

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), false, "Login failed");
        //productsPage.closePage();

    }




}
