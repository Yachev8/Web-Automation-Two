package AutomationWeb2.LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SuccessfulLogin {
    static WebDriver driver;
    @BeforeAll
    public static void LoginPage(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }
    @AfterAll
    public static void Close(){
        driver.quit();
        driver.close();
    }
    @Test
    @DisplayName("Havigate to website")
    public void HavigateToSite(){
        driver.get("https://www.saucedemo.com/");

    }
    @Test
    @DisplayName("Successful Login")
        public void SuccLogin(){
            driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
            driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();


        }


        @Test
        @DisplayName("Check the word Product")
    public void VerifyWord(){
        boolean status = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
            Assertions.assertTrue(status);
        }

    }


