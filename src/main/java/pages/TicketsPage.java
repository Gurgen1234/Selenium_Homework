package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TicketsPage extends AbstractPage{

    private Select filter;
    private Select queueFilter;
    public void selectFilter () {
        filter  = new Select(driver.findElement(By.cssSelector("[name=\"select\"]")));
        filter.selectByValue("Queue");
        filter.selectByValue("Keywords");
    }
    public void selectQueueFilter (String selectQueueText){
        queueFilter = new Select(driver.findElement(By.cssSelector("[name=\"queue\"]")));
        queueFilter.selectByVisibleText(selectQueueText);
    }
    public void sendKeyWord (String sendKeyWordText ){
        driver.findElement(By.id("id_query")).sendKeys(sendKeyWordText);
    }
    private WebElement applyBtn;
    public void applyBtnClick (){
        applyBtn = driver.findElement(By.cssSelector("[value=\"Apply Filters\"]"));
        applyBtn.click();
    }
    private WebElement examination;
    public String startExamination(){
        examination = driver.findElement(By.xpath( "//table/tbody/tr/td[2]/div"));
        return examination.getText().substring(examination.getText().indexOf("Ticket"));
    }

}
