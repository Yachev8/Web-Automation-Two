package AutomationWeb2.AllButtonsInHomePAge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestMenu {
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
    @DisplayName("Check the first product")
    public void CheckFirstProduct() throws InterruptedException {
        driver.findElement(By.xpath(" //*[@id=\"item_4_title_link\"]/div")).click();
        Thread.sleep(1000);
        boolean status1 = driver.findElement(By.xpath(" //*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")).isDisplayed();
        Assertions.assertTrue(status1 );


    }
    @Test
    @DisplayName("Check the ADD TO CARD button")
    public void AddToCardButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        Thread.sleep(1000);
        boolean sta = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).isDisplayed();
        Assertions.assertTrue( sta);
    }
}


