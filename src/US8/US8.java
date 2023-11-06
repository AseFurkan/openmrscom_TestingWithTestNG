package US8;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US8 extends BaseDriver {
    @Test
    public void test1() {
        login();
        WebElement hastakaydı = driver.findElement
                (By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        hastakaydı.click();

        WebElement kontrol = driver.findElement(By.xpath("(//div[@class='container-fluid'])/h2[1]"));
        Assert.assertTrue(kontrol.getText().equalsIgnoreCase("Find Patient Record"));

        WebElement patienttop = driver.findElement(By.xpath("//div[@id='patient-search-results-table_info']"));
        wait.until(ExpectedConditions.visibilityOf(patienttop));
        Actions aksiyon = new Actions(driver);
        aksiyon.moveToElement(patienttop).build().perform();


        WebElement sonsay = driver.findElement(By.xpath("//a[text()='Last']"));
        if (sonsay.isDisplayed())
            sonsay.click();
        String[] say = patienttop.getText().split(" ");
        int hastsay = Integer.parseInt(say[5]);

        List<WebElement> patients = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(hastsay == patients.size(), "tutmadı");
        System.out.println("patients.size()+\" \"+hastsay = " + patients.size() + " " + hastsay);


    }
}
