package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AddUserPageObject extends BasePageObject {
  private final WebElement jobTitle;
  private final WebElement jobDescription;
  private final WebElement jobNotes;
  private final WebElement saveButton;

  public AddUserPageObject(WebDriver driver) {
    super(driver);
    jobTitle = driver.findElement(
        By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input"));
    jobDescription = driver.findElement(
        By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea"));
    jobNotes = driver.findElement(
        By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea"));
    saveButton = driver.findElement(
        By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]"));
  }

  public void enterJobTitle(String title) {
    fillInputField(jobTitle, title);
  }

  public void enterJobDescription(String description) {
    fillInputField(jobDescription, description);
  }

  public void enterJobNotes(String notes) {
    fillInputField(jobNotes, notes);
  }

  public void clickSaveButton() {
    clickButton(saveButton);
  }
}
