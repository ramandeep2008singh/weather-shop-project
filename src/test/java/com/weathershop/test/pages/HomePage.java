package com.weathershop.test.pages;

import com.weathershop.framework.base.BasePage;
import com.weathershop.framework.utilities.WaitUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    // ----- Locators ------

    @FindBy(how = How.CSS, using = ".row.justify-content-center>h2")
    private WebElement lblHeader;

    @FindBy(how = How.CSS, using = ".octicon.octicon-info")
    private WebElement toolTipInfoIcon;

    @FindBy(how = How.CSS, using = "[class^='container top-space']>[class^='row panel justify-content-center']")
    private WebElement panelTemprature;

    @FindBy(how = How.XPATH, using = "//div[@class='row justify-content-center top-space-20']/div[1]")
    private WebElement panelMoisturizers;

    @FindBy(how = How.XPATH, using = "//div[@class='row justify-content-center top-space-20']/div[2]")
    private WebElement panelSunscreens;

    @FindBy(how = How.CSS, using = "[href='/moisturizer']>button")
    private WebElement btnBuyMoisturizers;

    @FindBy(how = How.CSS, using = "[href='/sunscreen']>button")
    private WebElement btnBuySunscreens;

    @FindBy(how = How.ID, using = "temperature")
    private WebElement lblTempratureText;

    // ----- Getters ------

    public WebElement getLblHeader() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblHeader);
        return lblHeader;
    }

    public WebElement getToolTipInfoIcon() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(toolTipInfoIcon);
        return toolTipInfoIcon;
    }

    public WebElement getPanelTemprature() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(panelTemprature);
        return panelTemprature;
    }

    public WebElement getPanelMoisturizers() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(panelMoisturizers);
        return panelMoisturizers;
    }

    public WebElement getPanelSunscreens() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(panelSunscreens);
        return panelSunscreens;
    }

    public WebElement getBtnBuyMoisturizers() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(btnBuyMoisturizers);
        return btnBuyMoisturizers;
    }

    public WebElement getBtnBuySunscreens() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(btnBuySunscreens);
        return btnBuySunscreens;
    }

    public WebElement getLblTempratureText() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblTempratureText);
        return lblTempratureText;
    }

    // ----- HomePage Specific Methods ------

    public void clickOnBuyMoisturizer() {
        getBtnBuyMoisturizers().click();
    }

    public void clickOnBuySunscreens() {
        getBtnBuySunscreens().click();
    }

}
