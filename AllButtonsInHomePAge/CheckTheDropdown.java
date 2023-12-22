package AutomationWeb2.AllButtonsInHomePAge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckTheDropdown {
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
    @DisplayName("Click dropdown field and verify low to high work correctly")
    public void VerifyDropdown() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
        Thread.sleep(3000);
        boolean status = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).isDisplayed();
        Assertions.assertTrue(status);
    }
    @Test
    @DisplayName("Click dropdown field and verify high to low work correctly")
    public void VerifyDropd(){
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).click();
        boolean status1 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).isDisplayed();
        Assertions.assertTrue(status1);
    }
}
