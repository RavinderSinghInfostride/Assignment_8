package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class AddProductToCart {
    WebDriver driver;
    WebDriverWait wait;

    By addToCartButton = By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
    By cartLink = By.xpath("//a[@class='shopping_cart_link']");
    By checkoutButton = By.xpath("//button[contains(@class,'checkout_button')]");
    By firstNameInput = By.xpath("//input[@name='firstName']");
    By lastNameInput = By.xpath("//input[@name='lastName']");
    By zipCodeInput = By.xpath("//input[@name='postalCode']");
    By continueButton = By.xpath("//input[@name='continue']");
    By productAddedVerify = By.xpath("//div[@class='inventory_item_name']");
    By priceOfProductAddedVerify = By.xpath("//div[@class='summary_total_label']");
    By finishButton = By.xpath("//button[@name='finish']");
    By backHomeButton = By.xpath("//button[@name='back-to-products']");

    public AddProductToCart(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addProductToCartAndCheckout() throws IOException {
        driver.findElement(addToCartButton).click();
        driver.findElement(cartLink).click();
        driver.findElement(checkoutButton).click();
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestDataFile.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String firstName = sheet.getRow(1).getCell(0).getStringCellValue();
        String lastName = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(zipCodeInput).sendKeys("123456");
        driver.findElement(continueButton).click();
        String isProductAddedRight = driver.findElement(productAddedVerify).getText();
        Assert.assertEquals("Sauce Labs Backpack", isProductAddedRight);
        String isPriceOfProductAddedRight = driver.findElement(priceOfProductAddedVerify).getText();
        Assert.assertEquals("Total: $32.39", isPriceOfProductAddedRight);
        driver.findElement(finishButton).click();
        driver.findElement(backHomeButton).click();
    }
}