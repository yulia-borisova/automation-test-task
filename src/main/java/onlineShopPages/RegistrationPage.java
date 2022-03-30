package onlineShopPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageObject {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Registration_FirstName")
    private WebElement firstNameField;

    @FindBy(id = "Registration_LastName")
    private WebElement lastNameField;

    @FindBy(id = "Registration_EmailAddress")
    private WebElement emailField;

    @FindBy(id = "Registration_DateOfBirthDay")
    private WebElement dayOfBirthField;

    @FindBy(id = "Registration_DateOfBirthMonth")
    private WebElement monthOfBirthField;

    @FindBy(id = "Registration_DateOfBirthYear")
    private WebElement yearOfBirthField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "Registration_ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "Registration_IsSubscriber")
    private WebElement checkBoxIsSubscribed;

    @FindBy(id = "RegistrationSubmit")
    private WebElement registerButton;

    //methods
    @Step("Fill in all required fields for registration ")
    public void fillInTheFields(String firstName, String lastName, String email, String dateOfBirth, String monthOfBirth,
                                String yearOfBirth, String password) {
        this.firstNameField.sendKeys(firstName);
        this.lastNameField.sendKeys(lastName);
        this.emailField.sendKeys(email);
        this.dayOfBirthField.sendKeys(dateOfBirth);
        this.monthOfBirthField.sendKeys(monthOfBirth);
        this.yearOfBirthField.sendKeys(yearOfBirth);
        this.passwordField.sendKeys(password);
        this.confirmPasswordField.sendKeys(password);
        this.checkBoxIsSubscribed.click();
    }

    @Step("Click Submit button to Register")
    public UserPage clickRegisterButton() {
        this.registerButton.click();
        return new UserPage(driver);
    }
}