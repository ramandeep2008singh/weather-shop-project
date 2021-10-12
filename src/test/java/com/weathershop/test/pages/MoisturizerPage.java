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

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p/following-sibling::button")
    private List<WebElement> btnAdd;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[contains(text(),'Aloe')]/following-sibling::p")
    private List<WebElement> lblMoisturizerAloePrices;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[contains(text(),'Almond')]/following-sibling::p")
    private List<WebElement> lblMoisturizerAlmondPrices;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[contains(text(),'Aloe')]/following-sibling::button")
    private List<WebElement> btnAddMoisturizer;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[contains(text(),'Almond')]/following-sibling::button")
    private List<WebElement> btnAddMoisturizerAlmond;

    @FindBy(how = How.XPATH, using = "//*[text()='2 item(s)']")
    private WebElement btnWithText;

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

    public List<WebElement> getBtnAdd() {
        return btnAdd;
    }

    public List<WebElement> getLblMoisturizerAloePrices() {
        return lblMoisturizerAloePrices;
    }

    public List<WebElement> getLblMoisturizerAlmondPrices() {
        return lblMoisturizerAlmondPrices;
    }

    public List<WebElement> getBtnAddMoisturizer() {
        return btnAddMoisturizer;
    }

    public List<WebElement> getBtnAddMoisturizerAlmond() {
        return btnAddMoisturizerAlmond;
    }

    public WebElement getBtnWithText() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(btnWithText);
        return btnWithText;
    }

}
