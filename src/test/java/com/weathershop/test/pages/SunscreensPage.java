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

    @FindBy(how = How.CLASS_NAME, using = "btn btn-primary")
    private List<WebElement> btnAddSunscreens;

    @FindBy(how = How.CSS, using = ".text-center.col-4>p:nth-child(3)")
    private List<WebElement> lblSunscreensPrices;

    @FindBy(how = How.CSS, using = ".text-center.col-4>p:nth-child(2)")
    private List<WebElement> lblSunscreensNames;

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

    public List<WebElement> getLblSunscreensPrices() {
        return lblSunscreensPrices;
    }

    public List<WebElement> getLblSunscreensNames() {
        return lblSunscreensNames;
    }

    // ---- SunscreensPage Specific Methods ----

    public void getLeastExpensiveSPF_50Sunscreen() {
        List<WebElement> spf50List = getPage(SunscreensPage.class).getLblSunscreensNames();
        WaitUtil.waitForPageToLoad();
        for (int i = 0; i < spf50List.size(); i++) {
            if (spf50List.get(i).getText().contains("SPF-50")) {
                System.out.println(spf50List.get(i).getText());
            }
        }

    }

}
