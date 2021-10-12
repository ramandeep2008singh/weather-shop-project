package com.weathershop.framework.utilities;

import com.weathershop.framework.base.DriverContext;
import com.weathershop.framework.config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This util holds all the common wait methods
 */
public class WaitUtil {

    static WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), 30);

    public static void waitForPageToLoad() {
        var remoteWebDriver = (RemoteWebDriver)(DriverContext.getDriver());
        String executor = remoteWebDriver.executeScript("return document.readyState").toString();
        ExpectedCondition<Boolean> jsLoad = webDriver -> executor.equals("complete");
        //Get JS Ready
        boolean jsReady = remoteWebDriver.executeScript("return document.readyState").toString().equals("complete");
        if (!jsReady)
            wait.until(jsLoad);
        else
            Settings.logs.write("Page is ready !");
    }

    public static void waitForElementVisible(final WebElement elementFindBy) {
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

    public static void waitForElementTextVisible(final WebElement elementFindBy, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy, text));
    }

    public static void waitUntilTextDisplayed(final By element, String text) {
        wait.until(textDisplayed(element, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text) {
        return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
    }

    public static void waitElementEnabled(final By elementFindBy) {
        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
    }

    public static void scrollToElement(final WebElement elementFindBy) {
        var actions = new Actions(DriverContext.getDriver());
        actions.moveToElement(elementFindBy);
        actions.perform();
    }

    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
        js.executeScript("window.scrollBy(0,300)");
    }

    public static void scrollTop() {
        JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
        js.executeScript("window.scrollBy(0,0)");
    }

    public static String getCurURL() {
        return DriverContext.getDriver().getCurrentUrl();
    }

    public static void waitForURLToLoad(String urlContains) {
        wait.until(ExpectedConditions.urlContains(urlContains));
    }

}
