package com.company.tests;

import com.company.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class VerifyAddItemTests extends BaseTest {

    @Test
    public void VerifyAddItem() {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.addSamsungGalaxyS6();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
        System.out.println("dada");
        /*Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage);
        alert.accept();// Print Alert Message*/

    }

}
