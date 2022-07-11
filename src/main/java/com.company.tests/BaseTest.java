package com.company.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected String url;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
        this.driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\comp\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        //this.driver = new FirefoxDriver();

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
