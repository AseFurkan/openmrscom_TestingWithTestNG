package US4;
import Utility.BaseDriver;
import Utility.MyFunc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US4 extends BaseDriver {

    @Test
    public void Test4(){

        login();

        WebElement registerPatient = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
        registerPatient.click();

        MyFunc.bekle(1);

        WebElement given = driver.findElement(By.name("givenName"));
        given.sendKeys("admin");

        MyFunc.bekle(1);

        WebElement familyName = driver.findElement(By.name("familyName"));
        familyName.sendKeys("admin");

        MyFunc.bekle(1);

        WebElement next = driver.findElement(By.id("next-button"));
        next.click();

        MyFunc.bekle(1);

        WebElement male = driver.findElement(By.xpath("//*[@value='M']"));
        male.click();

        MyFunc.bekle(1);

        WebElement next2 = driver.findElement(By.xpath("//*[@class='fas fa-chevron-right']"));
        next2.click();

        MyFunc.bekle(1);

        WebElement day = driver.findElement(By.cssSelector("[type='text'][id='birthdateDay-field']"));
        day.sendKeys("07");

        MyFunc.bekle(1);

        WebElement webMenu=driver.findElement(By.name("birthdateMonth"));
        Select monthMenu=new Select(webMenu);
        monthMenu.selectByVisibleText("December");

        MyFunc.bekle(1);

        WebElement year = driver.findElement(By.name("birthdateYear"));
        year.sendKeys("1995");

        MyFunc.bekle(1);

        WebElement next3 = driver.findElement(By.id("next-button"));
        next3.click();

        MyFunc.bekle(1);

        WebElement adress = driver.findElement(By.cssSelector("[type='text'][id='address1']"));
        adress.sendKeys("Toronto Canada");

        MyFunc.bekle(1);

        WebElement next4 = driver.findElement(By.id("next-button"));
        next4.click();

        MyFunc.bekle(1);

        WebElement phoneNumber = driver.findElement(By.name("phoneNumber"));
        phoneNumber.sendKeys("05555555555");

        MyFunc.bekle(1);

        WebElement next5 = driver.findElement(By.xpath("//*[@class='fas fa-chevron-right']"));
        next5.click();

        MyFunc.bekle(1);

        WebElement webMenu2=driver.findElement(By.name("relationship_type"));
        Select typeMenu=new Select(webMenu2);
        typeMenu.selectByVisibleText("Patient");

        MyFunc.bekle(1);

        WebElement name = driver.findElement(By.cssSelector("[type='text'][placeholder='Person Name']"));
        name.sendKeys("admin");

        MyFunc.bekle(1);

        WebElement next6 = driver.findElement(By.id("next-button"));
        next6.click();

        MyFunc.bekle(1);

        WebElement confirm = driver.findElement(By.id("submit"));
        confirm.click();

        MyFunc.bekle(1);

        WebElement id = driver.findElement(By.xpath("//*[@class='float-sm-right']"));
        WebElement patientName = driver.findElement(By.xpath("//*[@class='labeled']"));

      Assert.assertTrue(id.isDisplayed());
      Assert.assertTrue(patientName.isDisplayed());

    }

}
