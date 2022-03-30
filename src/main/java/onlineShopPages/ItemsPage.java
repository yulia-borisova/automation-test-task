package onlineShopPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ItemsPage extends PageObject {
    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"navlist\"]/li[1]")
    WebElement firstItemToBuy;

    @FindBy(xpath = "//*[@id=\"liItem\"]")
    WebElement itemSize;

    @FindBy(xpath = "//*[@id=\"aAddToBag\"]")
    WebElement addButton;

    @Step("Select Item to buy")
    public void selectItemToBuy() {
        this.firstItemToBuy.click();
        this.itemSize.click();
    }

    @Step("Click Buy Button")
    public void clickBuyButton() {
      //  Actions actions = new Actions(driver);
        actions.moveToElement(this.addButton).click().build().perform();
    }
}