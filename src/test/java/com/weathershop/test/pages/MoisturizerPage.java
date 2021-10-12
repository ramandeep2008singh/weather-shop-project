package com.weathershop.test.pages;

import com.weathershop.framework.base.BasePage;
import com.weathershop.framework.utilities.WaitUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MoisturizerPage extends BasePage {

    // ---- Locators ----

    @FindBy(how = How.CLASS_NAME, using = "thin-text nav-link")
    private WebElement btnCart;

    @FindBy(how = How.CSS, using = ".container h2")
    private WebElement lblMoisturizerHeader;

    @FindBy(how = How.CSS, using = ".octicon.octicon-info")
    private WebElement toolTipMoisturizerInfoIcon;

    @FindBy(how = How.CLASS_NAME, using = "btn btn-primary")
    private List<WebElement> btnAddMoisturizers;

    @FindBy(how = How.CSS, using = ".text-center.col-4>p:nth-child(3)")
    private List<WebElement> lblMoisturizerPrices;

    @FindBy(how = How.CSS, using = ".text-center.col-4>p:nth-child(2)")
    private List<WebElement> lblMoisturizerNames;

    // ---- Getters ----

    public WebElement getBtnCart() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(btnCart);
        return btnCart;
    }

    public WebElement getLblMoisturizerHeader() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblMoisturizerHeader);
        return lblMoisturizerHeader;
    }

    public WebElement getToolTipMoisturizerInfoIcon() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(toolTipMoisturizerInfoIcon);
        return toolTipMoisturizerInfoIcon;
    }

    public List<WebElement> getBtnAddMoisturizers() {
        return btnAddMoisturizers;
    }

    public List<WebElement> getLblMoisturizerPrices() {
        return lblMoisturizerPrices;
    }

    public List<WebElement> getLblMoisturizerNames() {
        return lblMoisturizerNames;
    }

    // ---- MoisturizerPage specific methods ----


}
