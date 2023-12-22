package AutomationWeb2.AllButtonsInHomePAge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class CheckPaymentMethod {
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
    public void myATest() {
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    @DisplayName("Successful Login")
    public void myBTest() {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();


    }

    @Test
    @DisplayName("Open the product Sauce Labs Bolt T-Shirt and click add to card")
    public void myCTest()  {
        driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
    }


    @Test
    @DisplayName("Finish Payment Method")
    public void myDTest()  {

        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        //check the text in correct page
        boolean check = driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).isDisplayed();
        Assertions.assertEquals(true, check);
        //click checkout button
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        //Checkout information

    }
        @Test
        @DisplayName("Checkout information")
        public void myETest(){


        driver.findElement(By.id("first-name")).sendKeys("joro");
        driver.findElement(By.id("last-name")).sendKeys("Yachev");
        driver.findElement(By.id("postal-code")).sendKeys("4444");
        driver.findElement(By.id("continue")).click();
        //check the final cost
        //String st = "Total: $17.27";
        boolean aa = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")).isDisplayed();
        Assertions.assertTrue( aa);


        //Click Finish
        driver.findElement(By.id("finish")).click();
    }

    @Test
    @DisplayName("Check for successfull message for payment")
    public void myJTest() {
        String succ = "Thank you for your order!";
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
      Assertions.assertEquals(succ,element1.getText());

    }
}




