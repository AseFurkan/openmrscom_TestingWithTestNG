package US6;

import Utility.BaseDriver;
import Utility.MyFunc;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class US6 extends BaseDriver {

    @Test
    public void test6() {
        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.cssSelector("[class='zak-button']"));
        demoBtn.click();

        WebElement demo2Btn = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        demo2Btn.click();
        MyFunc.bekle(2);

        WebElement demo2Entr = driver.findElement(By.xpath("//*[text()='Enter the OpenMRS 2 Demo']"));
        demo2Entr.click();

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("admin");
        MyFunc.bekle(2);

        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("Admin123");
        MyFunc.bekle(2);

        WebElement InpatientWard = driver.findElement(By.id("Inpatient Ward"));
        InpatientWard.click();
        MyFunc.bekle(2);

        WebElement loginButton = driver.findElement(By.cssSelector("[class='btn confirm']"));
        loginButton.click();
        MyFunc.bekle(2);

        WebElement patientBtn = driver.findElement(By.cssSelector("[class='icon-search']"));
        patientBtn.click();
        MyFunc.bekle(2);

        WebElement patientSearch = driver.findElement(By.id("patient-search"));
        patientSearch.sendKeys("100HM1"+Keys.ENTER);
        MyFunc.bekle(5);


        WebElement idBtn= driver.findElement(By.xpath("//span[text()='100HM1']"));
        Assert.assertTrue(idBtn.isDisplayed());
        MyFunc.bekle(2);

        driver.navigate().back();

        MyFunc.bekle(2);


        WebElement errorSend= driver.findElement(By.id("patient-search"));
        errorSend.sendKeys("Alper");
        MyFunc.bekle(2);


        WebElement errorMesage= driver.findElement(By.cssSelector("[class='dataTables_empty']"));
        Assert.assertTrue(errorMesage.getText().contains("No"));












    }
}