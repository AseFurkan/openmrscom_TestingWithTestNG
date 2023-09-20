package US5;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class US5 extends BaseDriver {
    @Test
    public void test5() {
        login();

        Actions aksiyonlar = new Actions(driver);

        WebElement profile = driver.findElement(By.cssSelector("[class='icon-user small']"));
        aksiyonlar.moveToElement(profile).build().perform();

        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();

        List<WebElement> liste = driver.findElements(By.cssSelector("[class='button app big']"));
        for (int i = 0; i < liste.size(); i++) {
            Assert.assertTrue(liste.get(i).getText().equals("Change Password"));
            Assert.assertTrue(liste.get(i + 1).getText().equals("My Languages"));
            break;
        }
    }
}
