package askomdch.com.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    //private WebDriver driver;

    @Attachment(value = "Failure Screenshot", type = "image/png")
     public static byte[] getCaptureScreenShor(WebDriver driver)
     {
         return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
     }
}
