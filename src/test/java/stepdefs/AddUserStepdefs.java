package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AddUserPageObject;
import pageobjects.BasePageObject;
import pageobjects.LoginPageObject;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AddUserStepdefs {
  public WebDriver driver;
  private AddUserPageObject pageObject;

  @Before(value = "@AddUser", order = 0)
  public void initWebDriver() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    this.driver = new ChromeDriver();
  }

  @Before(value = "@AddUser", order = 1)
  public void authenticateUserAndGoToCreateUserPage() throws InterruptedException {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    TimeUnit.SECONDS.sleep(2);

    LoginPageObject loginPage = new LoginPageObject(driver);
    loginPage.enterUsername("Admin");
    loginPage.enterPassword("admin123");
    loginPage.clickLoginButton();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle");
    TimeUnit.SECONDS.sleep(2);
    pageObject = new AddUserPageObject(driver);
  }

  @And("I filled all fields")
  public void iCorrectlyFilledAllFields(List<Map<String, String>> table) {
    Map<String, String> userData = table.get(0);
    pageObject.enterJobTitle(userData.get("Job title"));
    pageObject.enterJobDescription(userData.get("Job description"));
    pageObject.enterJobNotes(userData.get("Job notes"));
  }

  @When("I click on \"Save\" button")
  public void iClickOnSaveButton() {
    pageObject.clickSaveButton();
  }

  @After("@AddUser")
  public void closeBrowser(Scenario scenario) {
    if (scenario.isFailed()) {
      Allure.addAttachment("Screenshot",
          new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    pageObject.quit();
  }
}
