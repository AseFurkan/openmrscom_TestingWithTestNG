package US9;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class US9_EDIT extends BaseDriver {

    @Test
    public void TC_0909() {

        US9_POMElements_EDIT elements = new US9_POMElements_EDIT();
        login();
        //HASTA OLUŞTURMA KISMI
        List<String> registerPatients = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            elements.homeIcon.click();
            elements.registerAPatientBtn.click();
            Actions actions = new Actions(driver);
            wait.until(ExpectedConditions.elementToBeClickable(elements.given));
            actions.click(elements.given)
                    .sendKeys("Hasta").sendKeys(Keys.TAB)
                    .sendKeys("Team").sendKeys(Keys.TAB)
                    .sendKeys("selenium").sendKeys(Keys.ENTER)
                    .sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
                    .sendKeys("7").sendKeys(Keys.TAB)
                    .sendKeys(Keys.DOWN).sendKeys(Keys.TAB)
                    .sendKeys("1907").sendKeys(Keys.TAB)
                    .sendKeys("istanbul").sendKeys(Keys.TAB)
                    .sendKeys("ANKARA").sendKeys(Keys.TAB)
                    .sendKeys("iSTANBUL").sendKeys(Keys.TAB)
                    .sendKeys("KADIKÖY").sendKeys(Keys.TAB)
                    .sendKeys("TURKİYE").sendKeys(Keys.TAB)
                    .sendKeys("34920").sendKeys(Keys.TAB)
                    .sendKeys("02127777777").sendKeys(Keys.TAB)
                    .build().perform();

            wait.until(ExpectedConditions.visibilityOf(elements.relationshipType));
            Select relationType = new Select(elements.relationshipType);
            relationType.selectByIndex(2);
            elements.personName.sendKeys("777");
            wait.until(ExpectedConditions.elementToBeClickable(elements.nextBtn));
            elements.nextBtn.click();
            elements.confirm.click();
            registerPatients.add(elements.ids.get(0).getText());
        }

        //HASTA BİRLEŞTİRME KISMI
        elements.homeIcon.click();
        wait.until(ExpectedConditions.visibilityOf(elements.dataManagement));
        elements.dataManagement.click();
        wait.until(ExpectedConditions.visibilityOf(elements.mergePatientElectronic));
        elements.mergePatientElectronic.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.patient1));
        elements.patient1.click();
        elements.patient1.sendKeys(registerPatients.get(0)+Keys.TAB);
        elements.patient2.sendKeys(registerPatients.get(1));
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
        boolean control=!(patients.add(registerPatients.get(0))&&patients.add(registerPatients.get(1)));
        _softAssert.assertTrue(control,"Birleştirilen idler uyumsuzdur.");

        _softAssert.assertAll();


        BekleVeKapat();


    }


}

