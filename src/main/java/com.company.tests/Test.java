package com.company.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.testng.annotations.Test
    public void VerifyReadTable() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();

        WebElement tblExample1 = driver.findElement(By.xpath("//table[@id='table1']"));

        List<String> header = new ArrayList<String>();

        List<WebElement> headerSpan = tblExample1.findElements(By.xpath(".//span"));

        for(int i = 0; i < headerSpan.size(); i++) {
            header.add(headerSpan.get(i).getText());
        }

        WebElement body = tblExample1.findElement(By.xpath(".//tbody"));

        List<WebElement> rows = body.findElements(By.xpath(".//tr"));

        for(int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.xpath(".//td"));

            for(int j = 0; j < cells.size(); j++) {
                System.out.println(header.get(j) + " : " + cells.get(j).getText());
            }

        }


    }

    @org.testng.annotations.Test
    public void VerifyWriteToTable() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();

        WebElement tblExample1 = driver.findElement(By.xpath("//table[@id='table1']"));

        List<String> header = new ArrayList<String>();

        List<WebElement> headerSpan = tblExample1.findElements(By.xpath(".//span"));

        for(int i = 0; i < headerSpan.size(); i++) {
            header.add(headerSpan.get(i).getText());
        }

        WebElement body = tblExample1.findElement(By.xpath(".//tbody"));

        List<WebElement> rows = body.findElements(By.xpath(".//tr"));

        for(int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.xpath(".//td"));

            for(int j = 0; j < cells.size(); j++) {
                System.out.println(header.get(j) + " : " + cells.get(j).getText());
                if(header.get(j).equals("Last Name") && cells.get(j).getText().equals("Smith")) {
                    for(int k = 0; k < cells.size(); k++) {
                        if(header.get(k).equals("Email")) {
                            System.out.println("Set new email");
                        }
                    }
                    break;
                }
            }

        }


    }

}
