package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {
    private WebElement newTicket;
    private WebElement logIn;
    @Step("Нажатие кнопки Log In")
    public void LogInClick (){
        logIn = driver.findElement(By.id("userDropdown"));
        logIn.click();
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Нажатие кнопки New Ticket")
    public void newTicketClick (){
        newTicket = driver.findElement(By.cssSelector("[href=\"/tickets/submit/\"]"));
        newTicket.click();
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
}
