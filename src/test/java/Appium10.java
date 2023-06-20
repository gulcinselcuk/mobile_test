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
import java.util.List;

public class Appium10 {

    WebDriverWait wait;
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        /*
        sahibinden uygulamasinda scroll down and up
         */

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String filePath = System.getProperty("user.dir");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.sahibinden");
        capabilities.setCapability("appActivity", "com.sahibinden.ui.supplementary.UrlForwardingActivity");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");

        //scroll test
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By ePosta= By.id("com.sahibinden:id/e_mail_edit_text");
        wait.until(ExpectedConditions.presenceOfElementLocated(ePosta));
        driver.findElement(ePosta).sendKeys("gulcinsaribas@gmail.com");

        By girisButton= By.id("com.sahibinden:id/continue_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(girisButton));
        driver.findElement(girisButton).click();

        By password= By.id("com.sahibinden:id/password_edit_text");
        wait.until(ExpectedConditions.presenceOfElementLocated(password));
        driver.findElement(password).sendKeys("1712Rose");

        By closeButton= By.id("com.sahibinden:id/close_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(closeButton));
        driver.findElement(closeButton).click();

        By vasita = By.xpath("//android.widget.TextView[@text='Vasıta']");
        wait.until(ExpectedConditions.presenceOfElementLocated(vasita));
        driver.findElement(vasita).click();


        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;
        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence scroll = new Sequence(finger,0);

        scroll.addAction(finger.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX,startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX,endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));
        driver.perform(List.of(scroll));

        /*
        By havaAraclari = By.xpath("//android.widget.TextView[@text='Hava Araçları']");
        wait.until(ExpectedConditions.presenceOfElementLocated(havaAraclari));
        driver.findElement(havaAraclari).click();

         */

        int startX1 = driver.manage().window().getSize().getWidth() / 2;
        int startY1 = driver.manage().window().getSize().getHeight() /2;
        int endx = driver.manage().window().getSize().getWidth() / 2;
        int endY1 = (int) (driver.manage().window().getSize().getHeight() *0.8);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll1 = new Sequence(finger1, 0);
        scroll1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX1, startY1));
        scroll1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll1.addAction(finger1.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endx, endY1));
        scroll1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(scroll1));



    }



}
