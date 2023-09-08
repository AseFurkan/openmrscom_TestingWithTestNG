package US2;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US2 extends BaseDriver {
    @Test
    public void Test2(){
        login(); // Base driver içinde

        BekleVeKapat();
    }
}
