package org.example;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AppiumInspectorCode {
        private AndroidDriver driver = null;
        private String port = "4723";
        private String host = "127.0.0.1";

    @BeforeTest
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
            desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
            //desiredCapabilities.setCapability("appium:app", "/Users/ricky.bansal/Project/Appium/RIL_Loader.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
    }

        @Test
        public void sampleTest() throws InterruptedException {

/*            new TouchAction(driver)
                    .tap(tapOptions().withElement(element(androidElement)))
                    .waitAction(waitOptions(ofMillis(250))).perform();*/

            driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"R-Loader\"]")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("com.ril.loader:id/username")).sendKeys("Rikcy");
            driver.findElement(By.id("com.ril.loader:id/password")).sendKeys("Bansal");

        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }
    }

