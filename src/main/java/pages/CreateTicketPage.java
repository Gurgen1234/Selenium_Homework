package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class CreateTicketPage extends AbstractPage {
    private Select queue;
    private Select priority;
    private WebElement submitTicket;
    public void selectQueue (String selectQueueText) {
            queue  = new Select(driver.findElement(By.cssSelector("[name=\"queue\"]")));
            queue.selectByVisibleText(selectQueueText);
    }
    public void sendSummaryOfTheProblem (String sendSummaryOfTheProblemText) {
        driver.findElement(By.cssSelector("[name=\"title\"]")).sendKeys(sendSummaryOfTheProblemText);
    }
    public void selectPriority (String selectPriorityText) {
        priority  = new Select(driver.findElement(By.cssSelector("[name=\"priority\"]")));
        priority.selectByVisibleText(selectPriorityText);
    }
    public void sendDescription (String sendDescriptionText) {
        driver.findElement(By.cssSelector("[name=\"body\"]")).sendKeys(sendDescriptionText);
    }
    public void sendDate (String sendDateText) {
        driver.findElement(By.cssSelector("[name=\"due_date\"]")).sendKeys(sendDateText);
    }
    public void sendEMail (String sendEMailText) {
        driver.findElement(By.cssSelector("[name=\"submitter_email\"]")).sendKeys(sendEMailText);
    }
    public void clickSubmitTicket () {
        submitTicket  = driver.findElement(By.cssSelector("[class=\"btn btn-primary btn-lg btn-block\"]"));
        submitTicket.click();
    }
}
