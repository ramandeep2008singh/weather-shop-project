package com.weathershop.framework.base;

import com.weathershop.framework.config.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverContext {

    public static WebDriver Driver;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public static void goToUrl(String url) {
        DriverContext.getDriver().get(url);
    }

    private static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (Settings.environment.equalsIgnoreCase("hub")) {
            return remoteWebDriverThreadLocal.get();
        } else {
            return Driver;
        }
    }

    static void setRemoteWebDriverThreadLocal(RemoteWebDriver driverThreadLocal) {
        remoteWebDriverThreadLocal.set(driverThreadLocal);
    }

}
