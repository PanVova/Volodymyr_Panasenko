package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.qameta.allure.Allure;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPageObject;
import pageobjects.DeletePageObject;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class DeleteUserStepdefs {
  public WebDriver driver;
  private DeletePageObject pageObject;
  private String username;
  private int recordsAmount;

  @Before(value = "@SearchByUsername or @DeleteUser", order = 0)
  public void initWebDriver() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    this.driver = new ChromeDriver();
  }

  @Before(value = "@SearchByUsername or @DeleteUser", order = 1)
  public void authenticateUserAndGoToCreateUserPage() throws InterruptedException {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    TimeUnit.SECONDS.sleep(2);
    LoginPageObject loginPage = new LoginPageObject(driver);
    loginPage.enterUsername("Admin");
    loginPage.enterPassword("admin123");
    loginPage.clickLoginButton();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");
    TimeUnit.SECONDS.sleep(4);
    pageObject = new DeletePageObject(driver);
  }

  @And("I want to delete user with {string} username")
  public void iWantToDeleteUserWithUsername(String username) {
    this.username = username;

    for (int i = 1; i < pageObject.getRecordsAmount(); i++) {
      if (pageObject.getCurrentRecord(i).equals(username)) {
        pageObject.clickDeleteButton();
        pageObject.clickConfirmDeleteButton();
        break;
      }
    }
  }

  @And("Deleted successfully")
  public void deletedSuccessfully() {
    int newRecordsAmount = pageObject.getRecordsAmount();
    assertNotEquals(newRecordsAmount, recordsAmount);
  }

  @After("@DeleteUser")
  public void closeBrowser(Scenario scenario) {
    if (scenario.isFailed()) {
      Allure.addAttachment("Screenshot",
          new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    pageObject.quit();
  }
}
