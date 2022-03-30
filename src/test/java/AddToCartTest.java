import onlineShopPages.CartPage;
import onlineShopPages.HomePage;
import onlineShopPages.ItemsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddToCartTest extends BaseTest {
    HomePage homePageSteps = new HomePage(driver);
    ItemsPage buyItemSteps = new ItemsPage(driver);
    CartPage cartSteps = new CartPage(driver);

    @Test
    @DisplayName("TC: Non-Authorized User is able to add an Item to the Cart")
    public void checkAddingToCardNonAuth() {
        //given
        String expectedNumberOfItems = "1 item";
        driver.get(baseUrl);
        driver.switchTo().activeElement().findElement(By.className("close")).click();
        //when
        homePageSteps.openWomenCategoryItems();
        homePageSteps.selectItem();
        buyItemSteps.selectItemToBuy();
        buyItemSteps.clickBuyButton();
        homePageSteps.clickBagIcon();
        //then
        assertThat(cartSteps.getTotalItems())
                .as("Wrong total number of items in the cart")
                .isEqualTo(expectedNumberOfItems);
    }
}