package com.bejamas.assesment.tests;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bejamas.assesment.BaseTest;
import com.bejamas.assesment.pageobjects.TimetablePage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

public class SearchingConnectionsFormTests extends BaseTest {

  @Test
  @Description("New enquiry option - removes all previously filled fields")
  public void whenClickingNewEnquiry_shouldRemoveStationNames() {
    //given
    TimetablePage page = openPage();
    page.acceptCookiesPolicy();

    //when
    page.insertStationNames("Kraków Główny", "Katowice Ligota");

    //then
    assertFalse(page.isFromStationBoxEmpty());
    assertFalse(page.isToStationBoxEmpty());

    //when
    page.reloadPageWithNewEnquiry();

    //then
    assertTrue(page.isFromStationBoxEmpty());
    assertTrue(page.isToStationBoxEmpty());
  }

  @Test
  @Description("Adding and removing intermediate station box")
  public void whenAddIntermediateStationIsClicked_shouldStationNameBoxBeDisplayed() {
    //given
    TimetablePage page = openPage();
    page.acceptCookiesPolicy();

    //when
    page.clickAddIntermediateStationButton();

    //then
    assertTrue(page.isViaStationBoxDisplayed());
    assertTrue(page.isRemoveIntermediateStationButtonDisplayed());

    //when
    page.clickRemoveIntermediateStationButton();

    //then
    assertFalse(page.isViaStationBoxDisplayed());
    assertFalse(page.isRemoveIntermediateStationButtonDisplayed());
  }

  @Test
  @Description("Open and close date and time popup")
  public void whenClickSelectDate_shouldSelectDateAndTimePopupBeDisplayed() {
    //given
    TimetablePage page = openPage();
    page.acceptCookiesPolicy();

    //when
    page.openDateAndTimePopup();

    //then
    assertTrue(page.isDateAndTimePopupDisplayed());

    //when
    page.closeDateAndTimePopup();

    //then
    assertFalse(page.isDateAndTimePopupDisplayed());
  }

}
