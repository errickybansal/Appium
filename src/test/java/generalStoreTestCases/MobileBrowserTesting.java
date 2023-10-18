package generalStoreTestCases;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class MobileBrowserTesting extends BrowserBaseTestGS {

    @Test
    public void testCase() throws InterruptedException {
        driver.get("http://rahulshettyacademy.com/angularAppdemo");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.xpath("//a[contains(.,'Products ')]")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)","");
        String text = driver.findElement(By.xpath("//a[contains(.,'Devops')]")).getText();
        Assert.assertEquals(text,"Devops");
    }
}
