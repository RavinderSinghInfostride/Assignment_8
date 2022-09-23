package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private LoginPage loginPage;
    private AddProductToCart addProductToCart;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public AddProductToCart getAddProductToCart() {
        if (addProductToCart == null) {
            addProductToCart = new AddProductToCart(driver);
        }
        return addProductToCart;
    }
}