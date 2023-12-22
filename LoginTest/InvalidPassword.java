package AutomationWeb2.LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InvalidPassword {


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
    @DisplayName("Verify if a user cannot login with a valid username and an invalid password. ")
    public void InvaLogin() {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("locked_out_user");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        String stati1 = "Epic sadface: Password is required";
        Assertions.assertEquals("Epic sadface: Password is required", stati1);
    }

}

