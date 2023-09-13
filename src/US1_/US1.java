package US1_;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1 extends BaseDriver {

    @Test
    public void Test1() {

        driver.get("https://openmrs.org");

        WebElement demoButton = driver.findElement(By.xpath("(//*[@href='https://openmrs.org/demo/'])[2]"));
        demoButton.click();


        WebElement mrs2Button = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[2]"));
        mrs2Button.click();

        WebElement mrs2DemoButton = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[4]"));
        mrs2DemoButton.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement name = driver.findElement(By.id("username"));
        name.sendKeys("Adminn");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Adminn123");

        MyFunc.bekle(2);
        WebElement location = driver.findElement(By.id("Inpatient Ward"));
        location.click();

        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();

        Assert.assertFalse(driver.getCurrentUrl().equals("https://demo.openmrs.org/openmrs/referenceapplication/home.page"), "Yanlık kullanıcı adı veya şifre");


    }

}

