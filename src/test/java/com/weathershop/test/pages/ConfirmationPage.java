package com.weathershop.test.pages;

import com.weathershop.framework.base.BasePage;
import com.weathershop.framework.utilities.WaitUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConfirmationPage extends BasePage {

    // ---- Locators -----

    @FindBy(how = How.CSS, using = ".container h2")
    private WebElement lblCartHeader;

    @FindBy(how = How.CSS, using = ".octicon.octicon-info")
    private WebElement toolTipCartInfoIcon;

    @FindBy(how = How.CLASS_NAME, using = "text-justify")
    private WebElement lblSuccessMessage;

    // ---- Getters -----

    public WebElement getLblCartHeader() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblCartHeader);
        return lblCartHeader;
    }

    public WebElement getToolTipCartInfoIcon() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(toolTipCartInfoIcon);
        return toolTipCartInfoIcon;
    }

    public WebElement getLblSuccessMessage() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblSuccessMessage);
        return lblSuccessMessage;
    }

}
