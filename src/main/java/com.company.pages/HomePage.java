package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private String url;

    public HomePage(WebDriver driver) {
        super(driver);
        //this.url = "https://demoblaze.com/";
        this.url = super.url;
    }

    public void open() {
        driver.get(url);
        driver.manage().window().maximize();
    }

    private WebElement getSamsungGalaxyS6() {
        //return driver.findElement(By.xpath("//img[@src='imgs/galaxy_s6.jpg']"));
        return driver.findElement(By.xpath("//a[text()='Nokia lumia 1520']"));
    }

    public void addSamsungGalaxyS6() {
        this.getSamsungGalaxyS6().click();
    }

}
