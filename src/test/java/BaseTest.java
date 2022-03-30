import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class BaseTest {
    protected static WebDriver driver;
    public String baseUrl = "https://lv.sportsdirect.com/";

    @BeforeAll
    public static void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("before class working...");
    }

    //method to close Pop-up
    public void closeCountryPopUp() {
        driver.switchTo().activeElement().findElement(By.className("close")).click();
    }

    @AfterAll
    public static void clearAll() {
        driver.quit();
    }
}