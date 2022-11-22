package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPageObject;

public class LoginStepdefs {
  public WebDriver driver;
  public LoginPageObject pageObject;

  @Before("@Login")
  public void initWebDriver() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Given("I am filling credentials at the login page")
  public void iAmFillingCredentialsAtTheLoginPage() throws InterruptedException {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    TimeUnit.SECONDS.sleep(3);
    pageObject = new LoginPageObject(driver);
  }

  @Given("I entered {string} in the username field")
  public void iEnteredInTheUsernameField(String username) {
    pageObject.enterUsername(username);
  }

  @And("I entered {string} in the password field")
  public void iEnteredInThePasswordField(String password) {
    pageObject.enterPassword(password);
  }

  @When("I click on the \"Login\" button")
  public void iClickOnTheButton() {
    pageObject.clickLoginButton();
  }

  @After("@Login")
  public void closeBrowser(Scenario scenario) {
    if (scenario.isFailed()) {
      Allure.addAttachment("Screenshot",
          new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    pageObject.quit();
  }
}
