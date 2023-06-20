import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

    public class Appium04 {

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

            // getAttribute //to check done button can be clickable or not with empty name session?
            By getAttributeDoneButton = AppiumBy.ByAndroidUIAutomator.androidUIAutomator
                    ("new UiSelector().className(\"android.widget.Button\")");
            //driver.findElement(getAttributeDoneButton).getAttribute("enabled");
            String deneme = driver.findElement(getAttributeDoneButton).getAttribute("enabled");
            System.out.println(driver.findElement(getAttributeDoneButton).getAttribute("enabled").getClass().getName());

            Assert.assertFalse(Boolean.parseBoolean(driver.findElement(getAttributeDoneButton).getAttribute("enabled")));

            //----by gulcin
            //write text on name session
            By name= AppiumBy.ByAndroidUIAutomator.ByAndroidUIAutomator.androidUIAutomator
                    ("new UiSelector().className(\"android.widget.EditText\")");
            wait.until(ExpectedConditions.presenceOfElementLocated(name));
            driver.findElement(name).click();

           // driver.pressKey(new KeyEvent(AndroidKey.HOME));

            //driver.findElement(name).sendKeys("gulom"+"\n");--looks basic
//            wait.until(ExpectedConditions.presenceOfElementLocated(getAttributeDoneButton));
//            driver.findElement(getAttributeDoneButton).click();

//            String newData="gulo";---from internet
//            String command = "adb shell input text \""+newData+"\"";
//            Process result = Runtime.getRuntime().exec(command);




        }


    }

