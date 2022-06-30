package com.company.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected String url;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();

    }

    /*@BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();

    }*/

   /* @AfterMethod
    public void close() {
        this.driver.quit();
    }*/

    @AfterClass
    public void close() {
        this.driver.quit();
    }

}
