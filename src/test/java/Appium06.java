import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium06 {

    @Test

    /*
    Popup test
    Given App yuklensin
    When kullanici ana ekranda
    And kullanici "API Demos" butununa tikladi
    Then kullanici "API Demos" ekraninda
    And kullanici "Views" butununa tikladi
    Then kullanici "Views" ekraninda
    And kullanici "Popup Menu" butununa tikladi
    And kullici make popup butonuna tikladi
    And kullanici Search butununa tikladi
    Then popup mesaji onayla

     */
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities= new DesiredCapabilities();

        String filePath = System.getProperty("user.dir");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"/src/apps/apidemos.apk");
        capabilities.setCapability("appPackage","com.hmh.api");
        capabilities.setCapability("appActivity","com.hmh.api.ApiDemos");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"30000");
        //capabilities.setCapability("noReset",false);
        //capabilities.setCapability("autoGrantPermissions",true);

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        System.out.println("app installed");

        //uc izin mevcut ana sayfaya ilerlemek icin elementlere tikladik
        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();

        By okButton =By.id("android:id/button1");
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();

        By viewsButton=By.xpath("//android.widget.TextView[@text='Views']");
        wait.until(ExpectedConditions.presenceOfElementLocated(viewsButton));
        driver.findElement(viewsButton).click();

        By popUpButton = AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Popup Menu\"))");
        wait.until(ExpectedConditions.presenceOfElementLocated(popUpButton));
        driver.findElement(popUpButton).click();

        By makeAPopUp = AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.Button\")");
        wait.until(ExpectedConditions.presenceOfElementLocated(makeAPopUp));
        driver.findElement(makeAPopUp).click();

        By searchButton=By.xpath("//android.widget.TextView[@text='Search']");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
        driver.findElement(searchButton).click();

        By toastMessage=By.xpath("//android.widget.Toast");
        String message= driver.findElement(toastMessage).getText();
        String message2=driver.findElement(toastMessage).getAttribute("name");

        System.out.println(message+"\n"+message2);
        Assert.assertTrue(message2.contains("Search"));




    }
}
