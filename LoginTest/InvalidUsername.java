package AutomationWeb2.LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InvalidUsername {


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
    @DisplayName("user cannot login with a invalid username and an valid password")
    public void InvaLogin() {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_us");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        String stati1 = "Epic sadface: Username and password do not match any user in this service";
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", stati1);
    }


}