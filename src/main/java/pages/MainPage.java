package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {
    private WebElement newTicket;
    private WebElement logIn;
    public void LogInClick (){
        logIn = driver.findElement(By.id("userDropdown"));
        logIn.click();
    }
    public void newTicketClick (){
        newTicket = driver.findElement(By.cssSelector("[href=\"/tickets/submit/\"]"));
        newTicket.click();
    }
}
