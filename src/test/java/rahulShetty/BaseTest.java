package rahulShetty;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;

    @BeforeSuite
    public void configureAppium() throws InterruptedException, MalformedURLException {
              /* AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("/opt/homebrew/lib" +
               "/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
       service.start();
     */  UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Ricky");
        options.setApp("/Users/ricky.bansal/Personal/PersonalProject/Appium/src/test/java/resources/ApiDemos-debug" +
                ".apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public void longPressGesture(WebElement element,int duration){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement)element).getId(),"duration",duration));
    }

    public void scrollTillEnd(){
        boolean canBeScrolledMore;
        do{
            canBeScrolledMore = (Boolean)  ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left",100,"top",100,
                            "width",200,"height",200,"direction","down","percent",3.0));
        }while(canBeScrolledMore);
    }

    public void swipeByElement(WebElement element,String direction){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction",direction,
                "percent",0.75
        ));
    }

    public void dragAndDropGesture(WebElement element, int xAxis, int yAxis){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", xAxis,
                "endY", yAxis
        ));
    }

}
