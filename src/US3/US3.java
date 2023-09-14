package US3;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3 extends BaseDriver {
    @Test
    public void Test3(){
        login();

        MyFunc.bekle(2);
        WebElement logoutButton=driver.findElement(By.xpath("//a[@href='/openmrs/appui/header/logout.action?successUrl=openmrs']"));
        logoutButton.click();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.openmrs.org/openmrs/login.htm"),"Hatalı işlem login sayfasına yönlendirilemedi");


    }
}
