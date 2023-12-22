package AutomationWeb2.LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SuccessfulLogOut {
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
//        driver.quit();
//        driver.close();
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
    @DisplayName("Successful LogOut")
    public void myATest() throws InterruptedException {
        //click three lines up left
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        Thread.sleep(1000);
        //click Log out button
        driver.findElement(By.id("logout_sidebar_link")).click();

    }
    @Test
    @DisplayName("Verify successful Logout with check the text in login page: Accepted usernames are")
    public void myBTest()  {

        boolean check1 = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4")).isDisplayed();
        Assertions.assertTrue(check1);

    }
}
