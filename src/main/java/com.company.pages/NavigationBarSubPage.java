package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBarSubPage extends BasePage{

    public NavigationBarSubPage(WebDriver driver) {
         super(driver);
    }

    private WebElement getHome() {
        return driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
    }

    private WebElement getCart() {
        return driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
    }


    public void openHome() {
        this.getHome().click();
    }

    public void openCart() {
        this.getCart().click();
    }

}
