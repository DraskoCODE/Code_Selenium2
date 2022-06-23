package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

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
        this.url = url;
    }

    public void openPage() {
        driver.get(this.url);
        driver.manage().window().maximize();
    }

    public Boolean isDisplayed() {
        Boolean toReturn = true;
        //List<WebElement> listInventoryContainer = driver.findElements(By.id("inventory_container"));
        List<WebElement> listClassTitle = driver.findElements(By.className("title"));

        if(listClassTitle.size() != 1) {
            toReturn = false;
        }

        return toReturn;
    }

    public void closePage() {
        driver.quit();;
    }

}
