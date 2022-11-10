package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.logging.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

  public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
  public WebDriver driver;
  public WebDriver decorated;
  public WebDriverWait wait;

  @BeforeEach
  public void start() {

    if (tlDriver.get() != null) {
      driver = tlDriver.get();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      return;
    }
    ChromeOptions options = new ChromeOptions();
    driver = new  ChromeDriver(options);
    LoggingPreferences prefs = new LoggingPreferences();
    prefs.enable("browser", Level.ALL);
    decorated = new LoggingDecorator().decorate(driver);

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

  public static class LoggingDecorator extends WebDriverDecorator {

    @Override
    public void beforeCall(Decorated target, Method method, Object[] args) {
      System.out.println("before " +  target + " " + args );

    }
    @Override
    public void afterCall(Decorated target, Method method, Object[] args, Object res) {
      System.out.println("before " +  target + " " + args + " " + res);
    }

    @Override
    public Object onError(Decorated target, Method method, Object[] args,
            InvocationTargetException e) throws Throwable {
      return super.onError(target, method, args, e);
    }
  }
}
