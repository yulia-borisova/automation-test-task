import onlineShopPages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationTest extends BaseTest {
    public String registrationPage = "https://lv.sportsdirect.com/registration?returnUrl=%2f";
    private RegistrationPage registrationPageSteps = new RegistrationPage(driver);

    @Test
    @DisplayName("TestCase1: User is able to register")
    public void checkUserRegistration() throws InterruptedException {
        //given
        String name = "Jack";
        String lastName = "Smith";
        String email = "jackSmith12345@mailinator.com";
        String dateOfBirth = "10";
        String monthOfBirth = "March";
        String yearOfBirth = "1969";
        String password = "Password123$";
        String expectedPageAfterRegistration = "https://lv.sportsdirect.com/";
        driver.get(registrationPage);
        closeCountryPopUp();

        //when
        registrationPageSteps.fillInTheFields(name, lastName, email, dateOfBirth,
                monthOfBirth, yearOfBirth, password);
        //and
        Thread.sleep(2000); // added to avoid captcha
        registrationPageSteps.clickRegisterButton();
        Thread.sleep(2000);
        //then
        String actualPageAfterRegistration = driver.getCurrentUrl();
        assertThat(actualPageAfterRegistration)
                .as("Wrong Page after registration")
                .isEqualTo(expectedPageAfterRegistration);
    }
}