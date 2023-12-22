package AutomationWeb2.LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InvalidLoginBlank {


        static WebDriver driver;

        @BeforeAll
        public static void LoginPage() {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("Start-Maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }

        @AfterAll
        public static void Close() {
        driver.quit();
            driver.close();
        }

        @Test
        @DisplayName("Havigate to website")
        public void HavigateToSite() {
            driver.get("https://www.saucedemo.com/");

        }

        @Test
        @DisplayName("Verify the login page for both, when the field is blank and Submit button is clicked.")
        public void InvaLogin() {
           driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
            boolean check3 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).isDisplayed();
            Assertions.assertTrue(check3);
        }


    }

