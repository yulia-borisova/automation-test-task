import onlineShopPages.CartPage;
import onlineShopPages.HomePage;
import onlineShopPages.SearchResultPage;
import onlineShopPages.ItemsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest extends BaseTest {

    @Test
    @DisplayName("TestCase1: Non-authorized User is able to search an Item in a search-box")
    public void checkItemSearch() {
        //given
        String searchItem = "boots";
        String expectedPageUrl = baseUrl + "searchresults?descriptionfilter=" + searchItem;
        driver.get(baseUrl);
        HomePage homePageSteps = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        driver.switchTo().activeElement().findElement(By.className("close")).click();
        //when
        homePageSteps.searchForItem(searchItem);
        //and
        homePageSteps.clickEnterToSearch();

        //then
        assertThat(searchResultPage.verifyIfSearchResultIsPresent())
                .as("No result found")
                .isTrue();
        //and
        assertThat(searchResultPage.getResult())
                .as("Actual String is not as Expected")
                .isEqualTo(expectedPageUrl);
    }
}