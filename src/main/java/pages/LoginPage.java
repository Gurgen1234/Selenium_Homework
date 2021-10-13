package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private WebElement logInBtn;
    public void clickLogIn(){
        logInBtn = driver.findElement(By.cssSelector("[value=\"Login\"]"));
        logInBtn.click();
    }

    public void login(String user, String password) {
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(user);
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(password);
    }
}
