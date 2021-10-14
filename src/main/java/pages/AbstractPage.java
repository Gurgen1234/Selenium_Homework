package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected static WebDriver driver;
    public static void setDriver(WebDriver webDriver) {driver = webDriver;}
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] Ashot(byte[] screenShot) {
        return screenShot;
    }
    }

