package com.weathershop.framework.base;

import com.weathershop.framework.config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FrameworkInitialize extends BasePage {

    public void initializeBrowser(BrowserType browserType) throws MalformedURLException {

        switch (browserType) {

            case Chrome: {

                WebDriverManager.chromedriver().setup();

                if (Settings.environment.equalsIgnoreCase("hub")) {
                    var driver = new RemoteWebDriver(
                            new URL(Settings.seleniumGridHub),
                            capabilities().chrome());
                    DriverContext.setRemoteWebDriverThreadLocal(driver);
                } else {
                    WebDriver driver = new ChromeDriver();
                    DriverContext.setDriver(driver);
                }

                break;

            } case Firefox: {

                WebDriverManager.firefoxdriver().setup();

                if (Settings.environment.equalsIgnoreCase("hub")) {
                    var driver = new RemoteWebDriver(
                            new URL(Settings.seleniumGridHub),
                            capabilities().firefox());
                    DriverContext.setRemoteWebDriverThreadLocal(driver);
                } else {
                    WebDriver driver = new FirefoxDriver();
                    DriverContext.setDriver(driver);
                }

                break;

            } case IE: {

                WebDriverManager.iedriver().setup();

                if (Settings.environment.equalsIgnoreCase("hub")) {
                    var driver = new RemoteWebDriver(
                            new URL(Settings.seleniumGridHub),
                            capabilities().internetExplorer());
                    DriverContext.setRemoteWebDriverThreadLocal(driver);
                } else {
                    WebDriver driver = new InternetExplorerDriver();
                    DriverContext.setDriver(driver);
                }

                break;

            } case Safari: {

                WebDriverManager.safaridriver().setup();

                if (Settings.environment.equalsIgnoreCase("hub")) {
                    var driver = new RemoteWebDriver(
                            new URL(Settings.seleniumGridHub),
                            capabilities().safari());
                    DriverContext.setRemoteWebDriverThreadLocal(driver);
                } else {
                    WebDriver driver = new SafariDriver();
                    DriverContext.setDriver(driver);
                }

                break;

            } case Edge: {

                WebDriverManager.edgedriver().setup();

                if (Settings.environment.equalsIgnoreCase("hub")) {
                    var driver = new RemoteWebDriver(
                            new URL(Settings.seleniumGridHub),
                            capabilities().edge());
                    DriverContext.setRemoteWebDriverThreadLocal(driver);
                } else {
                    WebDriver driver = new EdgeDriver();
                    DriverContext.setDriver(driver);
                }

                break;
            }
        }
    }

    private DesiredCapabilities capabilities() {
        // Zalenium Capabilities
        var capabilities = new DesiredCapabilities();

        capabilities.setCapability("zal:name", "myTestName");
        capabilities.setCapability("zal:build", "myTestBuild");
        capabilities.setCapability("zal:tz", "Europe/Berlin");
        capabilities.setCapability("zal:screenResolution", "1280x720");
        capabilities.setCapability("zal:idleTimeout", 180);
        capabilities.setCapability("recordVideo", true);
        capabilities.setCapability("build", "1.0.0");

        return capabilities;
    }

}
