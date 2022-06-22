import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 {

    @Test
    public void VerifyLoginWithValidCredentials() {
    //public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        WebElement inpUserName = driver.findElement(By.id("user-name"));
        inpUserName.click();
        inpUserName.sendKeys("standard_user");

        WebElement inpPassword = driver.findElement(By.id("password"));
        inpPassword.click();
        inpPassword.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        List<WebElement> listInventoryContainer = driver.findElements(By.id("inventory_container"));
        List<WebElement> inventoryItems = listInventoryContainer.get(0).findElements(By.xpath("//div[@class='inventory_item']"));

        for(int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItem = inventoryItems.get(i);
            WebElement inventoryItemName = inventoryItem.findElement(By.className("inventory_item_name"));
            WebElement inventoryItemPrice = inventoryItem.findElement(By.className("inventory_item_price"));
            System.out.println(inventoryItemName.getText());
            System.out.println(inventoryItemPrice.getText());
        }

        Assert.assertEquals(listInventoryContainer.size(), 2, "Succesfully logged with invalid credentials");

        //Assert.assertEquals(true, driver.findElement(By.id("inventory_container")).isDisplayed());

        driver.quit();

    }

    @Test
    public void VerifyLoginWithInvalidCredentials() {
        //public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        WebElement inpUserName = driver.findElement(By.id("user-name"));
        inpUserName.click();
        inpUserName.sendKeys("standard_user");

        WebElement inpPassword = driver.findElement(By.id("password"));
        inpPassword.click();
        inpPassword.sendKeys("secret_saucee");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        List<WebElement> listInventoryContainer = driver.findElements(By.id("inventory_container"));


        Assert.assertEquals(listInventoryContainer.size(), 0, "Succesfully logged with invalid credentials");

        driver.quit();

    }

   @Test
    public void VerifyAddProduct() {
        //public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        WebElement inpUserName = driver.findElement(By.id("user-name"));
        inpUserName.click();
        inpUserName.sendKeys("standard_user");

        WebElement inpPassword = driver.findElement(By.id("password"));
        inpPassword.click();
        inpPassword.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        Integer numOfProductsBeforeAdd;

        WebElement lnkShoopingCartLink = driver.findElement(By.className("shopping_cart_link"));
        List<WebElement> spanShoppingCartBadge = lnkShoopingCartLink.findElements(By.xpath(".//span"));

        if(spanShoppingCartBadge.size() == 0) {
            numOfProductsBeforeAdd = 0;
        }
        else {
            numOfProductsBeforeAdd = Integer.parseInt(spanShoppingCartBadge.get(0).getText());
        }

        //WebElement btnAddToCartSauceLabsBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        //btnAddToCartSauceLabsBackpack.click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        WebElement btnRemove = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
        String btnRemoveText = btnRemove.getText();
        String btnInnerHTML = btnRemove.getAttribute("innerHTML");

        Assert.assertEquals(btnInnerHTML, "Remove");

        lnkShoopingCartLink = driver.findElement(By.className("shopping_cart_link"));
        spanShoppingCartBadge = lnkShoopingCartLink.findElements(By.xpath(".//span"));

        Assert.assertEquals(Integer.parseInt(spanShoppingCartBadge.get(0).getText()), numOfProductsBeforeAdd + 1, "Number is not equal");

        driver.quit();

    }

    @Test
    public void VerifyAddFirstProductToCart() {
        //public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        WebElement inpUserName = driver.findElement(By.id("user-name"));
        inpUserName.click();
        inpUserName.sendKeys("standard_user");

        WebElement inpPassword = driver.findElement(By.id("password"));
        inpPassword.click();
        inpPassword.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        List<WebElement> listInventoryContainer = driver.findElements(By.id("inventory_container"));
        List<WebElement> inventoryItems = listInventoryContainer.get(0).findElements(By.xpath("//div[@class='inventory_item']"));
        String name = inventoryItems.get(0).findElement(By.className("inventory_item_name")).getText();
        String price = inventoryItems.get(0).findElement(By.className("inventory_item_price")).getText();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        WebElement lnkShoopingCartLink = driver.findElement(By.className("shopping_cart_link"));
        lnkShoopingCartLink.click();

        WebElement cartList = driver.findElement(By.className("cart_list"));
        List<WebElement> cartItems = cartList.findElements(By.className("cart_item"));

        WebElement cartItemName = cartItems.get(0).findElement(By.className("inventory_item_name"));
        String cartItemNameValue = cartItemName.getText();

        WebElement cartItemPrice = cartItems.get(0).findElement(By.className("inventory_item_price"));
        String cartItemPriceValue = cartItemPrice.getText();
        //String cartItemPriceValue = "30.00";

        System.out.println(name + " vs " + cartItemNameValue);
        System.out.println(price + " vs " + cartItemPriceValue);
        Assert.assertEquals(name, cartItemNameValue);
        Assert.assertEquals(price, cartItemPriceValue);


        driver.quit();

    }

    /*@Test
    public void VerifyAddProductToCart() {
        //public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\comp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        WebElement inpUserName = driver.findElement(By.id("user-name"));
        inpUserName.click();
        inpUserName.sendKeys("standard_user");

        WebElement inpPassword = driver.findElement(By.id("password"));
        inpPassword.click();
        inpPassword.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        WebElement btnAddToCartSauceLabsBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        btnAddToCartSauceLabsBackpack.click();

        WebElement lnkShoopingCartLink = driver.findElement(By.className("shopping_cart_link"));
        lnkShoopingCartLink.click();

        //WebElement divInventoryItemName = driver.findElement(By.xpath(".//div[contains(text(), 'Sauce Labs Bolt T-Shirt']"));
        WebElement e = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        //WebElement checkbox= driver.findElement(By.xpath(".//div[text()=’Sauce Labs Bolt T-Shirt’]"));


        driver.quit();

    }*/

}
