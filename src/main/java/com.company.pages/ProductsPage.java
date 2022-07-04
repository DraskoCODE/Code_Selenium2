package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage extends BasePage {

    //private WebDriver driver;
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

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.url = super.url + "inventory.html";
    }

    public void openPage() {
        driver.get(this.url);
        driver.manage().window().maximize();
    }


    public Boolean isDisplayed() {
        Boolean toReturn = true;

       try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Thread.sleep(5000);

        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.numberOfElementsToBe(By.id("inventory_container"), 2));

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

    private WebElement getSortContainer() {
        return driver.findElement(By.xpath(".//select[@class='product_sort_container']"));
    }

    private WebElement getLowToHighItemFromList() {
        return driver.findElement(By.xpath(".//option[@value='lohi']"));
    }

    private WebElement getItemFromList(String value) {
        //return driver.findElement(By.xpath(".//option[text() = ‘" + value + "’]"));
        return driver.findElement(By.xpath("//option[text() = '" + value + "']"));
        //return driver.findElement(By.xpath("//*[text() = '" + "Price (low to high)" + "']"));
    }

    public String returnSelectedOption() {
        return this.getSortContainer().getAttribute("value");
    }

    public void selectLowToHigh() {
        this.getSortContainer().click();
        this.getLowToHighItemFromList().click();
    }

    public void  selectValue(String value) {
        this.getSortContainer().click();
       /* try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        this.getItemFromList(value).click();
        /*try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public Boolean isListSortedFromLowToHighByPrice() {
        Boolean toReturn = true;

        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath(".//div[@class='inventory_item']"));

        Double currentMaxPrice = -1.0;

        for(int i = 0; i < inventoryItems.size(); i++) {
            WebElement inentoryItemPrice = inventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_price']"));
            String inentoryItemPriceValue = inentoryItemPrice.getText();
            String tempPrice = inentoryItemPriceValue.substring(1, inentoryItemPriceValue.length());

            Double dblPrice = Double.parseDouble(tempPrice);

            //System.out.println(inentoryItemPriceValue);
            //System.out.println(tempPrice);

            if(dblPrice >= currentMaxPrice) {
                currentMaxPrice = dblPrice;
            }
            else {
                toReturn = false;
                break;
            }
        }

        return toReturn;
    }

    /*public Boolean isListSortedFromHighToLowByPrice() {
        Boolean toReturn = true;

        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath(".//div[@class='inventory_item']"));

        Double currentMaxPrice = 999999.0;

        for(int i = 0; i < inventoryItems.size(); i++) {
            WebElement inentoryItemPrice = inventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_price']"));
            String inentoryItemPriceValue = inentoryItemPrice.getText();
            String tempPrice = inentoryItemPriceValue.substring(1, inentoryItemPriceValue.length());

            Double dblPrice = Double.parseDouble(tempPrice);

            //System.out.println(inentoryItemPriceValue);
            //System.out.println(tempPrice);

            if(dblPrice <= currentMaxPrice) {
                currentMaxPrice = dblPrice;
            }
            else {
                toReturn = false;
                break;
            }
        }

        return toReturn;
    }*/

    public Boolean isListSortedFromHighToLowByPrice() {
        Boolean toReturn = true;

        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath(".//div[@class='inventory_item']"));

        for(int i = 0; i < inventoryItems.size() - 1; i++) {
            int j = i + 1;
            WebElement inentoryItemPriceFirst = inventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_price']"));
            String inentoryItemPriceValueFirst = inentoryItemPriceFirst.getText();
            String tempPriceFirst = inentoryItemPriceValueFirst.substring(1, inentoryItemPriceValueFirst.length());
            Double dblPriceFirst = Double.parseDouble(tempPriceFirst);

            WebElement inentoryItemPriceSecond = inventoryItems.get(j).findElement(By.xpath(".//div[@class='inventory_item_price']"));
            String inentoryItemPriceValueSecond = inentoryItemPriceSecond.getText();
            String tempPriceSecond = inentoryItemPriceValueSecond.substring(1, inentoryItemPriceValueSecond.length());
            Double dblPriceSecond = Double.parseDouble(tempPriceSecond);

            //if(dblPriceFirst > dblPriceSecond) {
            if(dblPriceFirst < dblPriceSecond) {
                toReturn = false;
                break;
            }
        }

        return toReturn;
    }


    public Boolean isListSortedFromAtoZbyName() {
        Boolean toReturn = true;

        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath(".//div[@class='inventory_item']"));

        for(int i = 0; i < inventoryItems.size() - 1; i++) {
            int j = i+1;
            WebElement inentoryItemNameFirst = inventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            String inventoryItemNameValueFirst = inentoryItemNameFirst.getText();

            WebElement inentoryItemNameSecond = inventoryItems.get(j).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            String inventoryItemNameValueSecond = inentoryItemNameSecond.getText();

            System.out.println(inventoryItemNameValueFirst + " vs " + inventoryItemNameValueSecond);


            if(inventoryItemNameValueFirst.compareToIgnoreCase(inventoryItemNameValueSecond) > 0) {
                toReturn = false;
                break;
            }
        }

        return toReturn;
    }

    public Boolean isListSortedFromZtoAbyName() {
        Boolean toReturn = true;

        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath(".//div[@class='inventory_item']"));

        for(int i = 0; i < inventoryItems.size() - 1; i++) {
            int j = i+1;
            WebElement inentoryItemNameFirst = inventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            String inventoryItemNameValueFirst = inentoryItemNameFirst.getText();

            WebElement inentoryItemNameSecond = inventoryItems.get(j).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            String inventoryItemNameValueSecond = inentoryItemNameSecond.getText();

            System.out.println(inventoryItemNameValueFirst + " vs " + inventoryItemNameValueSecond);


            if(inventoryItemNameValueFirst.compareToIgnoreCase(inventoryItemNameValueSecond) < 0) {
                toReturn = false;
                break;
            }
        }

        return toReturn;
    }

    public void closePage() {
        driver.close();;
    }



}
