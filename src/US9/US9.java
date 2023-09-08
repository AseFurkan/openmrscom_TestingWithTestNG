package US9;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class US9 extends BaseDriver {
    @Test
    public void Test1(){
        US9_POMElements elements=new US9_POMElements();
        login();
        elements.findPatientRecord.click();
        elements.searchPatient.click();
        elements.searchPatient.sendKeys("1001"+Keys.ENTER);



        BekleVeKapat();
    }
}
