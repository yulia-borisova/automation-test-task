package onlineShopPages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //List of Elements on the page
    @FindBy(id = "txtSearch")
    private WebElement itemSearchField;

    @FindBy(xpath = "//*[@id=\"divBagTotalLink\"]")
    private WebElement bagIcon;

    @FindBy(id = "BagQuantityContainer")
    private WebElement bagTotalItems;

    @FindBy(xpath = "//a[@href=\"/mens\"]")
    private WebElement menCategoryItems;

    @FindBy(xpath = "//a[@href =\"/mens/footwear/trainers\" ]")
    private WebElement menSubcategoryTrainers;

    @FindBy(xpath = "//a[@href=\"/ladies\"]")
    private WebElement womenCategoryItem;

    @FindBy(xpath = "//a[@href=\"/ladies/clothing/dresses\"]")
    private WebElement womenSubCategoryDress;

    //methods
    @Step("User is searching the item")
    public void searchForItem(String itemName) {
        this.itemSearchField.sendKeys(itemName);
    }

    @Step("User is clicking to get search Result")
    public SearchResultPage clickEnterToSearch() {
        this.itemSearchField.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

    @Step("Click Bag Icon and open Cart page")
    public CartPage clickBagIcon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.bagIcon).click().build().perform();
        return new CartPage(driver);
    }

    @Step("Open Women Category")
    public void openWomenCategoryItems() {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.womenCategoryItem).build().perform();
    }

    @Step("Select women cloth")
    public ItemsPage selectItem() {
        this.womenSubCategoryDress.click();
        return new ItemsPage(driver);
    }
}