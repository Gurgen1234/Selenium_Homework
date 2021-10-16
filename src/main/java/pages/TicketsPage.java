package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TicketsPage extends AbstractPage{

    private Select filter;
    private Select queueFilter;
    @Step("Выбор полей для фильтра")
    public void selectFilter (String selected) {
        filter  = new Select(driver.findElement(By.cssSelector("[name=\"select\"]")));
        filter.selectByValue(selected);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Выбор в поле Queue")
    public void selectQueueFilter (String selectQueueText){
        queueFilter = new Select(driver.findElement(By.cssSelector("[name=\"queue\"]")));
        queueFilter.selectByVisibleText(selectQueueText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    @Step("Заполнение поля KeyWords")
    public void sendKeyWord (String sendKeyWordText ){
        driver.findElement(By.id("id_query")).sendKeys(sendKeyWordText);
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    private WebElement applyBtn;
    @Step("Нажатие кнопки Apply")
    public void applyBtnClick (){
        applyBtn = driver.findElement(By.cssSelector("[value=\"Apply Filters\"]"));
        applyBtn.click();
        Ashot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }

    private WebElement examination;
    @Step("Проверка на наличие")
    public String startExamination(){
        examination = driver.findElement(By.xpath( "//table/tbody/tr/td[2]/div"));
        return examination.getText().substring(examination.getText().indexOf("Ticket"));
    }
}
