package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;

    By usernameInput = By.xpath("//input[@name='user-name']");
    By passwordInput = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//input[@name='login-button']");
    By landingPageVerifyAfterLogin = By.xpath("//span[@class='title']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginCredentials() throws IOException {
        FileReader reader = new FileReader("src/test/java/Properties/Data.properties");
        Properties data = new Properties();
        data.load(reader);
        driver.findElement(usernameInput).sendKeys(data.getProperty("username"));
        driver.findElement(passwordInput).sendKeys(data.getProperty("password"));
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void landingPageVerificationAfterLogin() {
        String isProductPageDisplayed = driver.findElement(landingPageVerifyAfterLogin).getText();
        Assert.assertEquals("PRODUCTS", isProductPageDisplayed);
    }
}