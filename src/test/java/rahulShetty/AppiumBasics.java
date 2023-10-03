package rahulShetty;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AppiumBasics extends BaseTest {

    @Test(enabled = false)
    public void wifiSettingsName() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Ricky's wifi");
        driver.findElement(By.id("android:id/button1")).click();
        driver.quit();
    }

    @Test(enabled = false)
    public void longPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
      WebElement element = driver.findElement(By.xpath("//*[@text='People Names']"));
      longPressGesture(element,3000);
       Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void scrollGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\")" +
                ");"));
        Thread.sleep(2000);
    }

    @Test(enabled = false)
    public void scrollGestureUsingCoOrdinates() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollTillEnd();
    }

    @Test(enabled = false)
    public void swipeGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement element = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
       Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),
               "true");

        swipeByElement(element,"Left");
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),
                "false");
        scrollTillEnd();
    }

    @Test
    public void dragDropGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragAndDropGesture(element,619,560);
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(),"Dropped!");
    }

}
