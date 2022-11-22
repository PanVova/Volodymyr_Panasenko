import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestScenarioHardcoded {
  private WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    driver = new ChromeDriver();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void test() throws InterruptedException {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    TimeUnit.SECONDS.sleep(5);

    String loginRaw = driver.findElement(
        By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]")).getText();
    String passwordRaw = driver.findElement(
        By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]")).getText();

    String login = loginRaw.substring(loginRaw.indexOf(":") + 2);
    String password = passwordRaw.substring(passwordRaw.indexOf(":") + 2);

    driver.findElement(By.xpath(
            "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
        .click(); // Login
    driver.findElement(By.xpath(
            "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
        .sendKeys(login);
    driver.findElement(By.xpath(
            "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
        .click(); // Password
    driver.findElement(By.xpath(
            "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
        .sendKeys(password);
    driver.findElement(
            By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))
        .click(); // Login button

    driver.get(
        "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle"); // Go to Admin -> Job - Job Titles

    TimeUnit.SECONDS.sleep(5);

    String jobTitle = "AAAA title";
    driver.findElement(
            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input"))
        .sendKeys(jobTitle); // Job title

    String description = "Very nasty desc";
    driver.findElement(
            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea"))
        .sendKeys(description); // Job description

    String notes = "Unique notes";
    driver.findElement(
            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea"))
        .sendKeys(notes); // Job notes

    driver.findElement(
            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]"))
        .click(); // Save button

    driver.get(
        "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList"); // Go to Admin -> Job - Job Titles

    TimeUnit.SECONDS.sleep(2);

    String recordsAmountRaw = driver.findElement(
            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[2]/div/span"))
        .getText(); // Records button

    String recordsAmountStr =
        recordsAmountRaw.substring(recordsAmountRaw.indexOf("(") + 1,
            recordsAmountRaw.indexOf(")"));
    int recordsAmount = Integer.parseInt(recordsAmountStr);

    for (int i = 1; i < recordsAmount; i++) {
      String currentRecord = driver.findElement(
              By.xpath(
                  String.format(
                      "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[%d]/div/div[2]/div",
                      i)))
          .getText(); // Job title
      if (currentRecord.equals(jobTitle)) {
        driver.findElement(
                By.xpath(
                    "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[1]/i")
            )
            .click(); // Delete button

        driver.findElement(
                By.xpath(
                    "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
            )
            .click(); // Delete yes, sure button
        break;
      }
    }

    driver.get(
        "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList"); // Go to Admin -> Job - Job Titles

    TimeUnit.SECONDS.sleep(2);

    String recordsAmountRawNew = driver.findElement(
            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[2]/div/span"))
        .getText(); // Save button

    String recordsAmountStrNew =
        recordsAmountRawNew.substring(recordsAmountRawNew.indexOf("(") + 1,
            recordsAmountRawNew.indexOf(")"));
    int recordsAmountNew = Integer.parseInt(recordsAmountStrNew);

    if (recordsAmountNew != recordsAmount) {
      System.out.println("Deleted successfully");
    }
  }
}
