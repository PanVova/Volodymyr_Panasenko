package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPageObject extends BasePageObject {
  private final WebElement usernameField;
  private final WebElement passwordField;
  private final WebElement loginButton;

  public LoginPageObject(WebDriver driver) {
    super(driver);
    usernameField = driver.findElement(By.xpath(
        "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
    passwordField = driver.findElement(By.xpath(
        "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
    loginButton = driver.findElement(
        By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
  }

  public void enterUsername(String username) {
    fillInputField(usernameField, username);
  }

  public void enterPassword(String password) {
    fillInputField(passwordField, password);
  }

  public void clickLoginButton() {
    clickButton(loginButton);
  }
}
