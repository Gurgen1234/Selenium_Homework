import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;

    @Before
    public void setup() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() throws IOException {
        driver.get(System.getProperty("site.url"));
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        MainPage mainPage = new MainPage();
        mainPage.newTicketClick();
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));

        String selectQueueText = "Django Helpdesk";
        String sendSummaryOfTheProblemText = "Ticket - " + UUID.randomUUID();
        String selectPriorityText = "2. High";
        String sendDescriptionText = "Готово";
        String sendDateText = "2021-10-30 00:00:00";
        String sendEMailText = "abc@gmail.com";

        CreateTicketPage createTicketPage = new CreateTicketPage();
        createTicketPage.selectQueue(selectQueueText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));

        createTicketPage.sendSummaryOfTheProblem(sendSummaryOfTheProblemText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        createTicketPage.selectPriority(selectPriorityText);
        createTicketPage.sendDescription(sendDescriptionText);
        createTicketPage.sendDate(sendDateText);
        createTicketPage.sendEMail(sendEMailText);
        createTicketPage.clickSubmitTicket();
        mainPage.LogInClick();
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        LoginPage loginPage = new LoginPage();
        loginPage.login(System.getProperty("user"), System.getProperty("password"));
        loginPage.clickLogIn();
        TicketsPage ticketsPage = new TicketsPage();
        ticketsPage.selectFilter("Queue");
        ticketsPage.selectFilter("Keywords");
        ticketsPage.selectQueueFilter(selectQueueText);
        ticketsPage.sendKeyWord(sendSummaryOfTheProblemText);
        ticketsPage.applyBtnClick();
        String foundItem = ticketsPage.startExamination();
        Assert.assertEquals(sendSummaryOfTheProblemText, foundItem);
        driver.close();
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] Ashot(byte[] screenShot) {
        return screenShot;
    }
}
