package com.weathershop.test.pages;

import com.weathershop.framework.base.BasePage;
import com.weathershop.framework.utilities.WaitUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SunscreensPage extends BasePage {

    // ---- Locators ----

    @FindBy(how = How.CLASS_NAME, using = "thin-text nav-link")
    private WebElement btnCart;

    @FindBy(how = How.CSS, using = ".container h2")
    private WebElement lblSunscreenHeader;

    @FindBy(how = How.CSS, using = ".octicon.octicon-info")
    private WebElement toolTipSunscreenInfoIcon;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[contains(text(),'SPF-50')]/following-sibling::button")
    private List<WebElement> btnAddSunscreens;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[contains(text(),'SPF-30')]/following-sibling::button")
    private List<WebElement> btnAddSunscreensSpf30;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p/following-sibling::button")
    private List<WebElement> btnAdd;

    @FindBy(how = How.CSS, using = ".text-center.col-4>p:nth-child(2)")
    private List<WebElement> lblSunscreensNames;

    @FindBy(how = How.CSS, using = ".text-center.col-4>p:nth-child(3)")
    private List<WebElement> lblSunscreensPrices;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[contains(text(),'SPF-50')]/following-sibling::p")
    private List<WebElement> lblSunscreensSPF50Prices;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[contains(text(),'SPF-30')]/following-sibling::p")
    private List<WebElement> lblSunscreensSPF30Prices;

    @FindBy(how = How.XPATH, using = "//*[text()='2 item(s)']")
    private WebElement btnWithText;

    // ---- Getters ----

    public WebElement getBtnCart() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(btnCart);
        return btnCart;
    }

    public WebElement getLblSunscreenHeader() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblSunscreenHeader);
        return lblSunscreenHeader;
    }

    public WebElement getToolTipSunscreenInfoIcon() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(toolTipSunscreenInfoIcon);
        return toolTipSunscreenInfoIcon;
    }

    public List<WebElement> getBtnAddSunscreens() {
        return btnAddSunscreens;
    }

    public List<WebElement> getBtnAddSunscreensSpf30() {
        return btnAddSunscreensSpf30;
    }

    public List<WebElement> getLblSunscreensSPF50Prices() {
        return lblSunscreensSPF50Prices;
    }

    public List<WebElement> getLblSunscreensSPF30Prices() {
        return lblSunscreensSPF30Prices;
    }

    public List<WebElement> getLblSunscreensNames() {
        return lblSunscreensNames;
    }

    public List<WebElement> getLblSunscreensPrices() {
        return lblSunscreensPrices;
    }

    public List<WebElement> getBtnAdd() {
        return btnAdd;
    }

    public WebElement getBtnWithText() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(btnWithText);
        return btnWithText;
    }

}
