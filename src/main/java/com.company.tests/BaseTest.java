package com.company.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected String url;

    @BeforeMethod
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        this.driver = new ChromeDriver();

    }

    @AfterClass
    public void afterMethod() {
        this.driver.quit();
    }

}
