package pageobjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeletePageObject extends BasePageObject {
  private final String recordsAmountStr;
  private final int recordsAmount;
  private final WebElement deleteButton;
  private WebElement deleteConfirmButton;

  public DeletePageObject(WebDriver driver) throws InterruptedException {
    super(driver);
    String recordsAmountRaw =
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[2]/div/span"))
            .getText();

    recordsAmountStr =
        recordsAmountRaw.substring(recordsAmountRaw.indexOf("(") + 1,
            recordsAmountRaw.indexOf(")"));

    recordsAmount = Integer.parseInt(recordsAmountStr);

    deleteButton = driver.findElement(By.xpath(
        "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[1]/i"));
  }

  public void clickDeleteButton() {
    clickButton(deleteButton);
  }

  public void clickConfirmDeleteButton()
  {
    deleteConfirmButton = driver.findElement(By.xpath(
        "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"));
    clickButton(deleteConfirmButton);
  }

  public int getRecordsAmount() {
    return recordsAmount;
  }

  public String getCurrentRecord(int index) {
    return driver.findElement(
            By.xpath(
                String.format(
                    "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[%d]/div/div[2]/div",
                    index)))
        .getText(); // Job title
  }
}
