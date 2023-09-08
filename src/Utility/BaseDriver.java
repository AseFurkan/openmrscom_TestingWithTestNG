package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver; //Singleton web driver
    public static WebDriverWait wait;
    static {   // public static driverBaslat() // bunun şartı extens olması ve basta yer alması
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    public static void BekleVeKapat(){
        MyFunc.bekle(3);
        driver.quit();

    }

    public void login(){

        driver.get("https://openmrs.org");

        WebElement demoButton = driver.findElement(By.xpath("(//*[@href='https://openmrs.org/demo/'])[2]"));
        demoButton.click();


        WebElement mrs2Button = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[2]"));
        mrs2Button.click();

        MyFunc.bekle(2);
        WebElement mrs2DemoButton = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[4]"));
        mrs2DemoButton.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement name = driver.findElement(By.id("username"));
        name.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        MyFunc.bekle(2);
        WebElement location = driver.findElement(By.id("Inpatient Ward"));
        location.click();

        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.openmrs.org/openmrs/referenceapplication/home.page"), "Yanlık kullanıcı adı veya şifre");

    }
}
