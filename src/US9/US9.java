package US9;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashSet;
import java.util.List;


public class US9 extends BaseDriver {

    @Test
    public void TC_0909(){

        US9_POMElements elements=new US9_POMElements();
        login();
        //RASTGELE ELEMAN ÇEKME
        elements.findPatientRecord.click();
        elements.searchPatient.click();
        elements.searchPatient.sendKeys("1001"+Keys.ENTER);
        String rndPatient1=randomPatient(elements.patients).getText().substring(0,6);
        String rndPatient2=randomPatient(elements.patients).getText().substring(0,6);
        elements.homeIcon.click();

        //BİRLEŞTİRME KISMI
        wait.until(ExpectedConditions.visibilityOf(elements.dataManagement));
        elements.dataManagement.click();
        wait.until(ExpectedConditions.visibilityOf(elements.mergePatientElectronic));
        elements.mergePatientElectronic.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.patient1));
        elements.patient1.click();
        elements.patient1.sendKeys(rndPatient1+Keys.TAB);
        elements.patient2.sendKeys(rndPatient2);
        elements.closeBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continueBtn));
        elements.continueBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.clickPatient1));
        SoftAssert _softAssert=new SoftAssert();
        boolean messageControl=elements.message.getText().contains("Merging cannot be undone!");

        _softAssert.assertTrue(messageControl,"İstenen mesaj alınamadı");
        elements.clickPatient1.click();
        elements.yesContinueBn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.showContactInfo));


        HashSet<String> patients = new HashSet<>();
        for (WebElement e:elements.ids) {
            patients.add(e.getText());
        }
        boolean control=!(patients.add(rndPatient1)&&patients.add(rndPatient2));
        _softAssert.assertTrue(control,"Birleştirilen idler uyumsuzdur.");

        _softAssert.assertAll();
        BekleVeKapat();

        }




    public WebElement randomPatient(List<WebElement> patients){
        int random=(int)(Math.random()*patients.size());
        return patients.get(random);
    }
    public void rightClick(){

    }
}
