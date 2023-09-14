package US7;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US7 extends BaseDriver {

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

        WebElement errorSend= driver.findElement(By.id("patient-search"));
        errorSend.sendKeys("Alper");
        MyFunc.bekle(2);
        errorSend.clear();
        MyFunc.bekle(2);

        WebElement errorMesage= driver.findElement(By.cssSelector("[class='dataTables_empty']"));
        Assert.assertTrue(errorMesage.getText().contains("No"));


        WebElement patientSearch = driver.findElement(By.id("patient-search"));
        patientSearch.sendKeys("100J27" + Keys.ENTER);
        MyFunc.bekle(5);


        WebElement deletePatient= driver.findElement(By.linkText("Delete Patient"));
        deletePatient.click();
        MyFunc.bekle(3);

        WebElement deleteText= driver.findElement(By.id("delete-reason"));
        deleteText.sendKeys("the patient was discharged");
        MyFunc.bekle(3);

        WebElement confirmRight= driver.findElement(By.xpath("(//button[@class='confirm right'])[6]"));
        confirmRight.click();
        MyFunc.bekle(2);






    }


}
