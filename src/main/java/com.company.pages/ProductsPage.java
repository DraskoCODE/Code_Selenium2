package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

       try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.id("inventory_container"), 2));

        List<WebElement> listInventoryContainer = driver.findElements(By.id("inventory_container"));
        //List<WebElement> listClassTitle = driver.findElements(By.className("title"));

        //ovaj deo koda je logika koja proverava dal smo na Products stranici
        if(listInventoryContainer.size() == 2) {
            toReturn = true;
        }
        else {
            toReturn = false;

        }

        return toReturn;
    }

    public void closePage() {
        driver.close();;
    }

}
