import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class Appium11 {
    WebDriverWait wait;

    @Test
    public void test() throws MalformedURLException {

        /*
         android ana sayfada swipe left and right
         */

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String filePath = System.getProperty("user.dir");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");

        //swipe test
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //get the screen dimensions
        Dimension screenSize= driver.manage().window().getSize();
        //set the swipes starting and ending points left to right
//        int startX= (int) (screenSize.width*0.8);
//        int startY=screenSize.height/2;
//        int endX=(int) (screenSize.width*0.2);
//        int endY=startY;

        int startX= (int) (screenSize.width*0.2);
        int startY=screenSize.height/2;
        int endX=(int) (screenSize.width*0.8);
        int endY=startY;

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe=new Sequence(finger,0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600),PointerInput.Origin.viewport(),endX,endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));

    }
}
