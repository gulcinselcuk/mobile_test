import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium01 {

    @Test
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

        //By secondOkButton=By.id("");
        //driver.findElement(secondOkButton).click();

        By preferenceButton= By.xpath("//android.widget.TextView[@text='Preference']");
        driver.findElement(preferenceButton).click();

//        By preferenceDependencies= By.xpath("//android.widget.TextView[@text='3. Preference dependencies']");
//        driver.findElement(preferenceDependencies).click();
//
//        By wifiOk= By.id("android:id/checkbox");
//        driver.findElement(wifiOk).click();

        //ok tiklanmis mi tiklanmamis mi acaba? diye test ettim.
//        WebElement wifiOk2= driver.findElement(By.id("android:id/checkbox"));
//        if(wifiOk2.getAttribute("checked").equals("false")){
//            System.out.println("ok is not clicked!");;
//        }else{
//            System.out.println("ok is already clicked!");
//
//        };

//        By wifiSettings= By.xpath("//android.widget.TextView[@text='WiFi settings']");
//        driver.findElement(wifiSettings).click();
//
//        By wifiText= By.id("android:id/edit");
//        driver.findElement(wifiText).sendKeys("wifiText");
//
//        By secondOkButton=By.id("android:id/button1");
//        driver.findElement(secondOkButton).click();

        By fragment=By.xpath("//android.widget.TextView[@text='7. Fragment']");
        driver.findElement(fragment).click();

        By switchButton=By.xpath("//android.widget.Switch[@bounds='[916,561][1038,632]']");
        driver.findElement(switchButton).click();
        driver.navigate().back();








    }
}
