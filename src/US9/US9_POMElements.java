package US9;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US9_POMElements {
    public US9_POMElements() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
    public WebElement findPatientRecord;
    @FindBy(css = "[id='patient-search']")
    public WebElement searchPatient;/////buraya 100 sayısıı yazdır sonra entera bastır.
    @FindBy(xpath = "//*[starts-with(text(),'1001')]")
    public List<WebElement> patients;///burdda 8 tane hasta var rastgele idlerini alın
    @FindBy(css = "[href='/openmrs/index.htm']")
    public WebElement homeIcon;//buraya 100 sayısıı yazdır sonra entera bastır.
    @FindBy(css = "[id='coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension']")
    public WebElement dataManagement;//data management
    @FindBy(css = "[id='coreapps-mergePatientsHomepageLink-app']")
    public WebElement mergePatientElectronic;//merge managment
    @FindBy(css = "input[id='patient1-text']")
    public WebElement patient1;//hasta 1
    @FindBy(css = "input[id='patient2-text']")
    public WebElement patient2;//hasta 2
    @FindBy(css = "[id='patient-search-clear-button']")
    public WebElement closeBtn;//rastgele continue aktiff olsun ddiye :)
    @FindBy(css = "[id='confirm-button']")
    public WebElement continueBtn;//hasta 2
    @FindBy(css = "[class='messages-container'] h1")
    public WebElement message;//Merging cannot be undone! yazısı geçiyor mu kontrol ettir
    @FindBy(css = "[id='first-patient']")
    public WebElement clickPatient1;
    @FindBy(css = "[id='second-patient']")
    public WebElement clickPatient2;
    @FindBy(css = "[id='confirm-button']")
    public WebElement yesContinueBn;
    @FindBy(css = "[id='coreapps-showContactInfo']")

    public WebElement showContactInfo;

    @FindBy(css = "[class='float-sm-right'] span")
    public List<WebElement> ids;//burdaki ikisi başta gönderilenle aynı mı bi bak


}
