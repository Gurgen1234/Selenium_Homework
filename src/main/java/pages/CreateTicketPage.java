package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import io.qameta.allure.Step;

public class CreateTicketPage extends AbstractPage {
    private Select queue;
    private Select priority;
    private WebElement submitTicket;
    @Step("Выбор Queue")
    public void selectQueue (String selectQueueText) {
            queue  = new Select(driver.findElement(By.cssSelector("[name=\"queue\"]")));
            queue.selectByVisibleText(selectQueueText);
            Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Заполнение SummaryOfTheProblem")
    public void sendSummaryOfTheProblem (String sendSummaryOfTheProblemText) {
        driver.findElement(By.cssSelector("[name=\"title\"]")).sendKeys(sendSummaryOfTheProblemText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Заполнение SummaryOfTheProblem")
    public void selectPriority (String selectPriorityText) {
        priority  = new Select(driver.findElement(By.cssSelector("[name=\"priority\"]")));
        priority.selectByVisibleText(selectPriorityText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Заполнение Description")
    public void sendDescription (String sendDescriptionText) {
        driver.findElement(By.cssSelector("[name=\"body\"]")).sendKeys(sendDescriptionText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Выбор Due")
    public void sendDate (String sendDateText) {
        driver.findElement(By.cssSelector("[name=\"due_date\"]")).sendKeys(sendDateText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Заполнение EMail")
    public void sendEMail (String sendEMailText) {
        driver.findElement(By.cssSelector("[name=\"submitter_email\"]")).sendKeys(sendEMailText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Нажатие кнопки SubmitTicket")
    public void clickSubmitTicket () {
        submitTicket  = driver.findElement(By.cssSelector("[class=\"btn btn-primary btn-lg btn-block\"]"));
        submitTicket.click();
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
}
