package onlineShopPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"SubtotalLabel\"]")
    WebElement totalItems;

    @Step("Get total number of items in the cart")
    public String getTotalItems() {
        return this.totalItems.getText();
    }
}