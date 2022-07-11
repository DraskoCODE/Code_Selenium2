package com.company.pages;

import com.company.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage {

    protected NavigationBarSubPage navigationBarSubPage;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        navigationBarSubPage = new NavigationBarSubPage(driver);
    }

    public void waitPageToBeOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("product-content"), 0));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));
    }

    public void waitAlertToBeOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    private WebElement getAddToCart() {
        return driver.findElement(By.xpath("//a[text()='Add to cart']"));

    }

    public CartPage addToCart() {
        this.getAddToCart().click();
        return new CartPage(driver);
    }

    public void openHome() {
        navigationBarSubPage.openHome();
    }

    public CartPage openCart() {
        navigationBarSubPage.openCart();;
        return new CartPage(driver);
    }

}
