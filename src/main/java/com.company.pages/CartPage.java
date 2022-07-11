package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class CartPage extends BasePage {

    private NavigationBarSubPage navigationBarSubPage;

    public CartPage(WebDriver driver) {
        super(driver);
        navigationBarSubPage = new NavigationBarSubPage(driver);
    }

    public void waitPageToBeOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.numberOfElementsToBe(By.className("table-responsive"), 1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]")));
    }

    public void waitPageToBeRendered() {
        WebElement totalPrice = this.getElementTotalPrice();
        String tempPrice = totalPrice.getText();

        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalPrice = this.getTable();
            if(tempPrice.equals(totalPrice.getText())) {
                break;
            }
        }
    }

    private WebElement getTable() {
        return driver.findElement(By.xpath("//table"));
    }

    private WebElement getElementTotalPrice() {
        return driver.findElement(By.id("totalp"));
    }

    //uradjeno sa statickom tabelom, razmisliti o resenju sa dinamickom tabelom
    private Integer getRowPositionByTitle(String title) {
        Integer toReturn = -1;

        WebElement body = this.getTable().findElement(By.xpath(".//tbody"));

        List<WebElement> rows = body.findElements(By.xpath(".//tr"));

        for(int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.xpath(".//td"));
            if(cells.get(1).getText().equals(title)) {
                toReturn = i;
                break;
            }
        }

        return toReturn;
    }

    //uradjeno sa statickom tabelom, razmisliti o resenju sa dinamickom tabelom
    public HashMap<String, Integer> getTableDataByTitle() {
        HashMap<String, Integer> toReturn = new HashMap<String, Integer>();

        WebElement body = this.getTable().findElement(By.xpath(".//tbody"));

        List<WebElement> rows = body.findElements(By.xpath(".//tr"));

        for(int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.xpath(".//td"));
            if(!toReturn.containsKey(cells.get(1).getText())) {
                toReturn.put(cells.get(1).getText(), 1);
            }
            else {
               Integer temp = toReturn.get(cells.get(1).getText());
               toReturn.put(cells.get(1).getText(), temp++);
            }
        }

        return toReturn;
    }

    public void deleteRowOnPosition(Integer position) {
        WebElement body = this.getTable().findElement(By.xpath(".//tbody"));

        List<WebElement> rows = body.findElements(By.xpath(".//tr"));

        WebElement row = rows.get(position);

        row.findElement(By.xpath(".//a")).click();

    }

    public void deleteRowByTitle(String title) {
        WebElement body = this.getTable().findElement(By.xpath(".//tbody"));

        List<WebElement> rows = body.findElements(By.xpath(".//tr"));

        WebElement row = rows.get(this.getRowPositionByTitle(title));

        row.findElement(By.xpath(".//a")).click();

    }

    public Double getTotalPrice() {
        return Double.parseDouble(this.getElementTotalPrice().getText());
    }

    public HomePage openHome() {
        navigationBarSubPage.openHome();
        return new HomePage(driver);
    }

}
