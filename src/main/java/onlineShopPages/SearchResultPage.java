package onlineShopPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PageObject {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="lblCategoryHeader")
    private WebElement searchResultHeader;

    @Step("Getting Search Result url")
    public String  getResult(){
      String url =  driver.getCurrentUrl();
        return url;
    }
    @Step("Verify if Search was performed")
    public boolean verifyIfSearchResultIsPresent(){
      boolean result =  this.searchResultHeader.isDisplayed();
      return result;
    }
}
