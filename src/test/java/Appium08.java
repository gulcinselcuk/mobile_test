import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class Appium08 {

    WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String filePath = System.getProperty("user.dir");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");

        // Drag and Drop test

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("app installed");

        // Uc izin mevcut ana sayfaya ilerlemek icin elementlere tikladik
        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();

        By okButton = By.id("android:id/button1");
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();

        By secondOkButton = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
        wait.until(ExpectedConditions.presenceOfElementLocated(secondOkButton));
        driver.findElement(secondOkButton).click();

        By apidemosButton = By.xpath("//android.widget.TextView[@text='API Demos']");
        wait.until(ExpectedConditions.presenceOfElementLocated(apidemosButton));
        driver.findElement(apidemosButton).click();

        By viewsButton=By.xpath("//android.widget.TextView[@text='Views']");
        wait.until(ExpectedConditions.presenceOfElementLocated(viewsButton));
        driver.findElement(viewsButton).click();

        By dragAndDropButton = By.xpath("//android.widget.TextView[@text='Drag and Drop']");
        wait.until(ExpectedConditions.presenceOfElementLocated(dragAndDropButton));
        driver.findElement(dragAndDropButton).click();

        By firstDot = By.id("com.touchboarder.android.api.demos:id/drag_dot_1");
        By secondDot = By.id("com.touchboarder.android.api.demos:id/drag_dot_2");
        By thirdDot = By.id("com.touchboarder.android.api.demos:id/drag_dot_3");


        // Perform drag and drop using PointerInput and PointerInputOptions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence dragAndDrop = new Sequence(finger,0);

        /* x ve y degerleri eksi - deger alabilir. 0'a 0 topun orta noktasi
        x'e eksi deger verirsen yatayda sola y'ye eksi deger verirsen dikey de yukari gider.
        1. 1. nokta ilk dairenin baslangic konumu
        2. hareket ettirme islemi
        3. 2. nokta ikinci dairenin bitis konumu
         */

        //ilk noktadan hareket ettirme islemi
        dragAndDrop.addAction(finger.createPointerMove
                (Duration.ofSeconds(2), PointerInput.Origin.fromElement(driver.findElement(firstDot)),0,0));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // ilk noktayi hareket ettirme
        dragAndDrop.addAction(finger.createPointerMove(
                Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(firstDot)),0,0));

        // ikinci noktaya hareket ettirme
        dragAndDrop.addAction(finger.createPointerMove(
                Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(secondDot)),0,0));

        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragAndDrop));

        Sequence dragAndDrop2 = new Sequence(finger,0);

        //========================================================================================
        By hiddenDot = By.id("com.touchboarder.android.api.demos:id/drag_dot_hidden");
        //ilk noktadan hareket ettirme islemi
        dragAndDrop2.addAction(finger.createPointerMove
                (Duration.ofSeconds(2), PointerInput.Origin.fromElement(driver.findElement(thirdDot)),0,0));
        dragAndDrop2.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // ilk noktayi hareket ettirme
        dragAndDrop2.addAction(finger.createPointerMove(
                Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(thirdDot)),0,0));

        // ikinci noktaya hareket ettirme
        dragAndDrop2.addAction(finger.createPointerMove(
                Duration.ofSeconds(2),PointerInput.Origin.fromElement(driver.findElement(hiddenDot)),0,0));

        dragAndDrop2.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragAndDrop2));




    }
}
