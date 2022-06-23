package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    private WebDriver driver;
    private String url;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        url = url;
    }

    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
    //WebDriver driver = new ChromeDriver();

    public BasePage(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragoje Janjevic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.url = url;
    }

    public BasePage() {

    }
}
