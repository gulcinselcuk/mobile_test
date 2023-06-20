import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class Appium07 {

    WebDriverWait wait;

    @Test
    public void test() throws IOException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String filePath = System.getProperty("user.dir");


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // index ile
        By continueButton = AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.Button\").index(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();

        // text ile
        By okButton = AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.Button\").text(\"OK\")");
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();

        // text startwith ile
        By addGesture = AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")");
        wait.until(ExpectedConditions.presenceOfElementLocated(addGesture));
        driver.findElement(addGesture).click();

        By name= AppiumBy.ByAndroidUIAutomator.ByAndroidUIAutomator.androidUIAutomator
                ("new UiSelector().className(\"android.widget.EditText\")");
        wait.until(ExpectedConditions.presenceOfElementLocated(name));
        driver.findElement(name).click();

        driver.findElement(name).sendKeys("gulom"+"\n");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        driver.hideKeyboard();

        By space=By.xpath("com.davemac327.gesture.tool:id/gestures_overlay");
        wait.until(ExpectedConditions.presenceOfElementLocated(space));
        driver.findElement(space).click();

        By done=By.xpath("//android.widget.Button[@text='Done']");
        wait.until(ExpectedConditions.presenceOfElementLocated(done));
        driver.findElement(done).click();





    }
}
