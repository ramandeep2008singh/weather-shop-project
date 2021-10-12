package com.weathershop.test.pages;

import com.weathershop.framework.base.BasePage;
import com.weathershop.framework.base.DriverContext;
import com.weathershop.framework.utilities.CommonTestUtil;
import com.weathershop.framework.utilities.ExcelUtil;
import com.weathershop.framework.utilities.WaitUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CartPage extends BasePage {

    // ---- Locators ----

    @FindBy(how = How.CSS, using = ".container h2")
    private WebElement lblCartHeader;

    @FindBy(how = How.CSS, using = ".octicon.octicon-info")
    private WebElement toolTipCartInfoIcon;

    @FindBy(how = How.CSS, using = ".table.table-striped>tbody td:first-child")
    private List<WebElement> lblCartItemName;

    @FindBy(how = How.CSS, using = ".table.table-striped>tbody td:last-child")
    private List<WebElement> lblCartItemPrice;

    @FindBy(how = How.ID, using = "total")
    private WebElement lblTotalPrice;

    @FindBy(how = How.CLASS_NAME, using = "stripe-button-el")
    private WebElement btnPayWithCard;

    @FindBy(how = How.CLASS_NAME, using = "layoutView contentView")
    private WebElement panelPaymentWindow;

    @FindBy(how = How.ID, using = "email")
    private WebElement textBoxEmail;

    @FindBy(how = How.ID, using = "card_number")
    private WebElement textBoxCardNumber;

    @FindBy(how = How.ID, using = "cc-exp")
    private WebElement textBoxExpiryDate;

    @FindBy(how = How.ID, using = "cc-csc")
    private WebElement textBoxCVVNumber;

    @FindBy(how = How.ID, using = "billing-zip")
    private WebElement textBoxZIPCode;

    @FindBy(how = How.ID, using = "submitButton")
    private WebElement btnSubmit;

    @FindBy(how = How.CSS, using = ".table.table-striped>tbody>tr:first-child>td:first-child")
    private WebElement lblFirstProductName;

    @FindBy(how = How.CSS, using = ".table.table-striped>tbody>tr:first-child>td:last-child")
    private WebElement lblFirstProductPrice;

    @FindBy(how = How.CSS, using = ".table.table-striped>tbody>tr:last-child>td:first-child")
    private WebElement lblSecondProductName;

    @FindBy(how = How.CSS, using = ".table.table-striped>tbody>tr:last-child>td:last-child")
    private WebElement lblSecondProductPrice;

    @FindBy(how = How.NAME, using = "stripe_checkout_app")
    private WebElement iFrame;

    // ---- Getters ----

    public WebElement getLblFirstProductName() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblFirstProductName);
        return lblFirstProductName;
    }

    public WebElement getLblFirstProductPrice() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblFirstProductPrice);
        return lblFirstProductPrice;
    }

    public WebElement getLblSecondProductName() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblSecondProductName);
        return lblSecondProductName;
    }

    public WebElement getLblSecondProductPrice() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblSecondProductPrice);
        return lblSecondProductPrice;
    }

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

    public List<WebElement> getLblCartItemName() {
        WaitUtil.waitForPageToLoad();
        return lblCartItemName;
    }

    public List<WebElement> getLblCartItemPrice() {
        WaitUtil.waitForPageToLoad();
        return lblCartItemPrice;
    }

    public WebElement getLblTotalPrice() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(lblTotalPrice);
        return lblTotalPrice;
    }

    public WebElement getBtnPayWithCard() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(btnPayWithCard);
        return btnPayWithCard;
    }

    public WebElement getPanelPaymentWindow() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(panelPaymentWindow);
        return panelPaymentWindow;
    }

    public WebElement getTextBoxEmail() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(textBoxEmail);
        return textBoxEmail;
    }

    public WebElement getTextBoxCardNumber() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(textBoxCardNumber);
        return textBoxCardNumber;
    }

    public WebElement getTextBoxExpiryDate() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(textBoxExpiryDate);
        return textBoxExpiryDate;
    }

    public WebElement getTextBoxCVVNumber() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(textBoxCVVNumber);
        return textBoxCVVNumber;
    }

    public WebElement getTextBoxZIPCode() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(textBoxZIPCode);
        return textBoxZIPCode;
    }

    public WebElement getBtnSubmit() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(btnSubmit);
        return btnSubmit;
    }

    public WebElement getiFrame() {
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(iFrame);
        return iFrame;
    }

    // ---- CartPage specific methods ----

    public void navigateToCartPage() {
        DriverContext.getDriver().get(ExcelUtil.readCell("Urls", 8));
        WaitUtil.waitForElementVisible(getPage(CartPage.class).getBtnPayWithCard());
    }

    public void fillPaymentDetails(String email, String cardNr, String expiry, String cvv, String zipCode) {
        getBtnPayWithCard().click();
        DriverContext.getDriver().switchTo().frame(getiFrame());
        WaitUtil.waitForElementVisible(getTextBoxEmail());
        getTextBoxEmail().sendKeys(email);
        CommonTestUtil.sendKeysWithJavaScript(cardNr, getTextBoxCardNumber());
        CommonTestUtil.sendKeysWithJavaScript(expiry, getTextBoxExpiryDate());
        getTextBoxCVVNumber().sendKeys(cvv);
        getTextBoxZIPCode().sendKeys(zipCode);
        getBtnSubmit().click();
        DriverContext.getDriver().switchTo().parentFrame();
        WaitUtil.waitForPageToLoad();
        WaitUtil.waitForElementVisible(getPage(ConfirmationPage.class).getLblSuccessMessage());
    }
}
