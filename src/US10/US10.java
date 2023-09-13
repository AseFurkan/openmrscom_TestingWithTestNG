package US10;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class US10 extends BaseDriver {

    @Test
    public void Test10(){

        login();

        WebElement Appointment=driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension"));
        Appointment.click();

        WebElement ManageAppointment=driver.findElement(By.id("appointmentschedulingui-manageAppointments-app"));
        ManageAppointment.click();

        WebElement searchId=driver.findElement(By.xpath("//input[@id='patient-search']"));
        searchId.sendKeys("100HYE");
        MyFunc.bekle(2);

        WebElement row=driver.findElement(By.xpath("//tbody[@aria-live='polite']"));
        row.click();
        MyFunc.bekle(2);




    }
}
