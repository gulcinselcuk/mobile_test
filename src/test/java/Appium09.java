import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Pause;
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
import java.util.Collection;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class Appium09 {
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



        /*
        API Demos expandable list
        Expandable list test
        App yuklensin
        kullanici ana ekranda
        kullanici "API Demos" butununa tikladi
        kullanici "API Demos" ekraninda
        kullanici "Views" butununa tikladi
        kullanici "Views" ekraninda
        kullanici "Expandable Lists" butununa tikladi
        kullanici "Views/Expandable Lists" ekraninda
        kullanici "1. Custom Adapter" butununa tikladi
        kullanici "People Names" butununa tikladi
        kullanici "Chuck" butununa uzun basti
        kullanici "Sample menu" ekraninda
         */

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

        By expandableList = By.xpath("//android.widget.TextView[@text='Expandable Lists']");
        wait.until(ExpectedConditions.presenceOfElementLocated(expandableList));
        driver.findElement(expandableList).click();

        By customAdapter = By.xpath("//android.widget.TextView[@text='1. Custom Adapter']");
        wait.until(ExpectedConditions.presenceOfElementLocated(customAdapter));
        driver.findElement(customAdapter).click();

        By peopleNames = By.xpath("//android.widget.TextView[@text='People Names']");
        wait.until(ExpectedConditions.presenceOfElementLocated(peopleNames));
        driver.findElement(peopleNames).click();

        By chuck = By.xpath("//android.widget.TextView[@text='Chuck']");
        wait.until(ExpectedConditions.presenceOfElementLocated(chuck));

        LongPressOptions longPressOptions = LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(driver.findElement(chuck)))
                .withDuration(Duration.ofMillis(2000));


        // Create a PointerInput instance
        PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH,"finger");

        // Create a sequence of actions
        Sequence longPress = new Sequence(pointer,0);

        longPress.addAction(pointer.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),
                driver.findElement(chuck).getLocation().getX(),driver.findElement(chuck).getLocation().getY()));

        longPress.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new Pause(pointer, Duration.ofMillis(2000))); // İstediğiniz süre kadar bekleyin
        longPress.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the sequence of actions
        driver.perform(Arrays.asList(longPress));













    }


}
