package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @Step("Заполнение Username и Password")
    public void login(String user, String password) {
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(user);
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(password);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    private WebElement logInBtn;
    @Step("Нажатие кнопки Login")
    public void clickLogIn(){
        logInBtn = driver.findElement(By.cssSelector("[value=\"Login\"]"));
        logInBtn.click();
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }

}
