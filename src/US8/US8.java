package US8;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US8 extends BaseDriver {
    @Test
    public void test1(){
        login();
        WebElement hastakaydı= driver.findElement
                (By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        WebElement sonsayfa= driver.findElement(By.xpath("//a[@id='patient-search-results-table_last']"));


    }
}
