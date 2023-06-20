import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium02 {

    WebDriverWait wait;

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //String filePath = System.getProperty("user.dir");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"10000");

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("app installed");

        driver.get("https://www.amazon.com");
        System.out.println(driver.getContext()+"app acildigindaki tur");

        By homeScreenLogo =By.cssSelector("android.view.View[content-desc='Amazon']");
        wait.until(ExpectedConditions.presenceOfElementLocated(homeScreenLogo));
        driver.findElement(homeScreenLogo).click();
        System.out.println("ana sayfadayiz");

        By signInButton =By.xpath("//android.widget.TextView[@text='Sign in ›']");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInButton));
        driver.findElement(signInButton).click();

        By welcomeText = By.xpath("//android.view.View[@text='Welcome']");
        wait.until(ExpectedConditions.presenceOfElementLocated(welcomeText));
        Assert.assertEquals(driver.findElement(welcomeText).getText(),"Welcome");


    }
}

