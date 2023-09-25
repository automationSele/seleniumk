package com.selenium;

import com.selenium.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;
import java.util.HashMap;
import java.util.Map;

public class SeleniumFunctions {
    public static WebDriver createDriver(String browserName, boolean headless) {
        String GUITestCasesProjectPath = System.getProperty("user.dir");
        BaseClass.driverPath = GUITestCasesProjectPath+"/src/test/java/resources/seleniumDrivers";
        if((System.getProperty("os.name").toLowerCase()).contains("window"))
        {
            BaseClass.driverPath = BaseClass.driverPath+"/"+"chromedriver_win.exe";
        }
        else if((System.getProperty("os.name").toLowerCase()).contains("mac"))
        {
            BaseClass.driverPath = BaseClass.driverPath+"/"+"chromedriver_mac";
        }

        WebDriver driverObj;
        if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(headless);
            firefoxOptions.addPreference("browser.download.dir", BaseClass.downloadFolder);
            firefoxOptions.addPreference("browser.download.folderList", 2);
            firefoxOptions.addPreference("dom.webnotifications.enabled", false);
            firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/*, text/log, text/sql, " +
                    "application/octet-stream, application/log, application/sql");
            firefoxOptions.addArguments("--width=1680");
            firefoxOptions.addArguments("--width=1050");
            System.setProperty("webdriver.gecko.driver", BaseClass.driverPath);
            driverObj = new FirefoxDriver(firefoxOptions);
            driverObj.manage().window().maximize();

            return driverObj;

        } else if (browserName.equalsIgnoreCase("Chrome")) {

            System.out.println("[info] - Required browser type is: "+browserName);

            Map<String, Object> prefs = new HashMap<String, Object>();
            System.out.println("The path of download folder is: " + BaseClass.downloadFolder);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            if (headless)
                chromeOptions.addArguments("--headless");
            chromeOptions.setExperimentalOption("prefs", prefs);
            chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--incognito");
            System.out.println("The path of the driver is: " + BaseClass.driverPath);
            System.setProperty("webdriver.chrome.driver",  BaseClass.driverPath);

            driverObj = new ChromeDriver(chromeOptions);
//            try {
//                driverObj.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
//            }catch(Exception e)
//            {
//                System.out.println("Page did not load in time but lets continue.");
//            }

//            driverObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
//            driverObj.manage().window().setSize(new Dimension(1680, 1050));

            return driverObj;
        }
        return null;
    }
    public static boolean selectFromDropdown(WebElement dropdownElement, String valueToBeSelected) {

        boolean status = true;

        try {
            Select targetDropdownForSelection = new Select(dropdownElement);
            targetDropdownForSelection.selectByVisibleText(valueToBeSelected);
        } catch (Exception e) {
            if (e.getMessage().contains("Cannot locate element with text")) {
//                BaseClass.getLogger().info("[info] - The specified dropdown option : " + valueToBeSelected
//                        + " : is not present in the dropdown list");
                status = false;
            } else if (e.getMessage().contains("Unable to locate element")) {
//                BaseClass.getLogger().info("[info] - The specified dropdown webelement is not located");
//                status = false;
            }

//            BaseClass.getLogger().info("[info] - inside selectFromDropdown method, exception occurred " + e);
        }
        return status;
    }
}
