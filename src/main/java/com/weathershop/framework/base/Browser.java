package com.weathershop.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser extends BasePage {

    private WebDriver driver;
    public BrowserType Type;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

}
