package com.bejamas.assesment;

import com.bejamas.assesment.pageobjects.TimetablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

  private static ChromeDriver chromeDriver;

  @BeforeAll
  public static void setupDriver() {
    WebDriverManager.chromedriver().setup();
    chromeDriver = new ChromeDriver();
  }

  @BeforeEach
  public void openTestPage() {
    getDriver().get("https://rozklad-pkp.pl/en");
  }

  @AfterEach
  public void clearTestPage() {
    chromeDriver.manage().deleteAllCookies();
  }

  @AfterAll
  public static void closeDriver() {
    chromeDriver.quit();
  }

  public static ChromeDriver getDriver() {
    return chromeDriver;
  }

  public TimetablePage openPage() {
    return new TimetablePage(getDriver());
  }

}
