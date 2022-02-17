package com.bejamas.assesment.pageobjects;


import static java.util.concurrent.TimeUnit.*;
import static org.awaitility.Awaitility.await;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimetablePage {

  @FindBy(id = "qc-cmp2-ui")
  private WebElement cookiesPopup;
  @FindBy(xpath = "//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")
  private WebElement agreeToCookiesButton;
  @FindBy(id = "wcag-h-reload")
  private WebElement newEnquiry;
  @FindBy(id = "from-station")
  private WebElement fromStationBox;
  @FindBy(id = "to-station")
  private WebElement toStationBox;
  @FindBy(xpath = "//*[@id=\"wyszukiwarka\"]/form/div[2]/div/a[1]/span[1]")
  private WebElement addIntermediateStation;
  @FindBy(xpath = "//*[@id=\"wyszukiwarka\"]/form/div[2]/div/a[2]/span[1]")
  private WebElement removeIntermediateStation;
  @FindBy(xpath = "//*[@id=\"wyszukiwarka\"]/form/div[3]/div[2]/div")
  private WebElement viaStationBox;
  @FindBy(xpath = "//*[@id=\"wyszukiwarka\"]/form/div[8]/div[2]/div[1]")
  private WebElement dateAndTimePopupButton;
  @FindBy(xpath = "//*[@id=\"wyszukiwarka\"]/form/div[8]/div[2]/div[2]/div")
  private WebElement dateField;
  @FindBy(xpath = "//*[@id=\"date-pick\"]/div")
  private WebElement dateAndTimePopup;
  @FindBy(xpath = "//*[@id=\"date-pick\"]/div/div[2]/button[1]")
  private WebElement selectDateButton;

  public TimetablePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void acceptCookiesPolicy() {
    await()
        .atMost(30, SECONDS)
        .pollInterval(1, SECONDS)
        .until(() -> isDisplayed(cookiesPopup));
    agreeToCookiesButton.click();
  }

  public boolean isDisplayed(WebElement webElement) {
    try {
      return webElement.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void reloadPageWithNewEnquiry() {
    newEnquiry.click();
    await()
        .atMost(10, SECONDS)
        .pollInterval(1, SECONDS)
        .until(() -> isDisplayed(dateField));
  }

  public boolean isFromStationBoxEmpty() {
    String fromStationText = fromStationBox.getAttribute("value");
    return fromStationText.isEmpty();
  }

  public boolean isToStationBoxEmpty() {
    String toStationText = toStationBox.getAttribute("value");
    return toStationText.isEmpty();
  }

  public void insertStationNames(String fromStation, String toStation) {
    fromStationBox.sendKeys(fromStation);
    toStationBox.sendKeys(toStation);
  }

  public void clickAddIntermediateStationButton() {
    addIntermediateStation.click();
  }

  public void clickRemoveIntermediateStationButton() {
    removeIntermediateStation.click();
  }

  public boolean isViaStationBoxDisplayed() {
    return isDisplayed(viaStationBox);
  }

  public boolean isRemoveIntermediateStationButtonDisplayed() {
    return isDisplayed(removeIntermediateStation);
  }

  public void openDateAndTimePopup() {
    dateAndTimePopupButton.click();
  }

  public boolean isDateAndTimePopupDisplayed() {
    return isDisplayed(dateAndTimePopup);
  }

  public void closeDateAndTimePopup() {
    selectDateButton.click();
  }

}
