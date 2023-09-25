package com.selenium.Testcases;

import com.selenium.BaseClass;
import com.selenium.SeleniumFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class STest1 {

        @Test
        public static void test1() throws Exception
        {
            BaseClass.driverObj = SeleniumFunctions.createDriver("Chrome",false);
            BaseClass.driverObj.get("https://demo.guru99.com/test/newtours/");

            String userNameCss = "input[name='userName']";
            String passwordCss = "input[name='password']";
            String submitBtnCss = "input[name='submit']";
            String flightLink  = "//a[text()='Flights']";
            String roundTripRadioBtnCss = "input[value='roundtrip']";
            String oneWayRadioBtnCss = "input[value='oneway']";
            String passengerCountDropDownCss = "select[name='passCount']";
            String fromPortDrpDownCss = "select[name='fromPort']";
            String fromMonthDrpDownCss = "select[name='fromMonth']";
            String fromDayDrpDownCss = "select[name='fromDay']";
            String toPortDrpDownCss = "select[name='toPort']";
            String toMonthDrpDownCss = "select[name='toMonth']";
            String toDayDrpDownCss = "select[name='toDay']";
            String couchRadioBtnCss = "input[value='Coach']";
            String businessRadioBtnCss = "input[value='Business']";
            String firstRadioBtnCss = "input[value='First']";
            String airlineDrpDownCss = "select[name='airline']";
            String findFlightBtn = "input[name='findFlights']";
            String crossButtonOnDiv = "div#dismiss-button";


            WebElement usernameWE = BaseClass.driverObj.findElement(By.cssSelector(userNameCss));
            WebElement passwordWE = BaseClass.driverObj.findElement(By.cssSelector(passwordCss));
            WebElement submitBtnWE = BaseClass.driverObj.findElement(By.cssSelector(submitBtnCss));


            usernameWE.sendKeys("admin");
            passwordWE.sendKeys("admin");
            submitBtnWE.click();
//        Thread.sleep(4000);
            WebElement flightLinkWE = BaseClass.driverObj.findElement(By.xpath(flightLink));
            flightLinkWE.click();
            Thread.sleep(9000);
            WebElement roundTripRadioBtnWE = BaseClass.driverObj.findElement(By.cssSelector(roundTripRadioBtnCss));

            WebElement fromPortDropDownWE = BaseClass.driverObj.findElement(By.cssSelector(fromPortDrpDownCss));
            WebElement passengerCountDropDownWE = BaseClass.driverObj.findElement(By.cssSelector(passengerCountDropDownCss));
            SeleniumFunctions.selectFromDropdown(passengerCountDropDownWE, "3");
      }

    }

