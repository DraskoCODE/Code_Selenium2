package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.Native;

public class HomePage extends BasePage {

    private String url;
    protected NavigationBarSubPage navigationBarSubPage;

    public HomePage(WebDriver driver) {
        super(driver);
        //this.url = "https://demoblaze.com/";
        this.url = super.url;
        navigationBarSubPage = new NavigationBarSubPage(driver);
    }

    public void open() {
        driver.get(url);
        driver.manage().window().maximize();
        //WebDriverWait wait = new WebDriverWait(driver, 500);
        //wait.until(ExpectedConditions.numberOfElementsToBe(By.id("contcont"), 1));
    }

    public void waitPageToBeOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("card"), 1));
    }

    private WebElement getSamsungGalaxyS6() {
        //return driver.findElement(By.xpath("//img[@src='imgs/galaxy_s6.jpg']"));
        //return driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));
        return driver.findElement(By.xpath("//a[contains(text(),'Sony vaio i5')]"));

    }

    private WebElement getItemByText(String name) {
        //return driver.findElement(By.xpath("//img[@src='imgs/galaxy_s6.jpg']"));
        //return driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));
        //return driver.findElement(By.xpath("//a[contains(text(),'Sony vaio i5')]"));
        return driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]"));

    }

    public void addSamsungGalaxyS6() {
        this.getSamsungGalaxyS6().click();
    }

    public ProductDetailsPage addItemByName(String itemName) {
        this.getItemByText(itemName).click();
        return new ProductDetailsPage(driver);
    }

    public String getProductPriceByName(String productName) {
        WebElement getProduct = this.getItemByText(productName);
        WebElement getParentH4 = getProduct.findElement(By.xpath(".//.."));
        WebElement getParentDiv = getParentH4.findElement(By.xpath(".//.."));

        WebElement price = getParentDiv.findElement(By.xpath(".//h5"));

        return price.getText();
    }

    public CartPage openCart() {
        navigationBarSubPage.openCart();
        return new CartPage(driver);
    }

}
