package org.example;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

  public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
  public WebDriver driver;
  public WebDriverWait wait;

  @BeforeEach
  public void start() {

    if (tlDriver.get() != null) {
      driver = tlDriver.get();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      return;
    }

    FirefoxOptions options = new FirefoxOptions();
    options.setCapability("webdriver.firefox.marionette", "true");
    driver = new FirefoxDriver(options);
    tlDriver.set(driver);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver,  Duration.ofSeconds(10));

    Runtime.getRuntime().addShutdownHook(
        new Thread(() -> { driver.quit(); driver = null; }));
  }

  @AfterEach
  public void stop() {
    driver.quit();
    driver = null;
  }
}
