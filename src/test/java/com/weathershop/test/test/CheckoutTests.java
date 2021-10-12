package com.weathershop.test.test;

import com.weathershop.framework.config.Settings;
import com.weathershop.framework.utilities.CommonTestUtil;
import com.weathershop.framework.utilities.ExcelUtil;
import com.weathershop.test.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckoutTests extends TestInitializer {

    private static int temperature;

    @Test(priority = 1)
    public void testFetchTemperature() {
        getPage(HomePage.class);
        temperature = CommonTestUtil.removeDegreeAndConvertToNumber(
                getPage(HomePage.class).getLblTempratureText());
        if (temperature < 19) {
            Settings.logs.write("--- Buying Moisturizers ---");
        } else {
            Settings.logs.write("--- Buying Sunscreens ---");
        }
    }

    @Test(dependsOnMethods = {"testFetchTemperature"}, priority = 2)
    public void testBuyMoisturizersProducts() {
        // Checking if temperature is less than 19 degrees
        if (!(temperature < 19)) {
            throw new SkipException("Skipping the test case");
        }

        // Creating LinkedHashMap to store the product name and price
        Map<String, BigDecimal> productAndPrice = new LinkedHashMap<>();

        getPage(HomePage.class).getBtnBuyMoisturizers().click();

        // Storing the least expensive product with 'Aloe'
        productAndPrice.putAll(CommonTestUtil.getLeastExpensiveProduct(
                getPage(MoisturizerPage.class).getLblMoisturizerNames(),
                getPage(MoisturizerPage.class).getLblMoisturizerPrices(),
                getPage(MoisturizerPage.class).getBtnAdd(),
                ExcelUtil.readCell("Values", 9)));

        // Storing the least expensive product with 'Almond'
        productAndPrice.putAll(CommonTestUtil.getLeastExpensiveProduct(
                getPage(MoisturizerPage.class).getLblMoisturizerNames(),
                getPage(MoisturizerPage.class).getLblMoisturizerPrices(),
                getPage(MoisturizerPage.class).getBtnAdd(),
                ExcelUtil.readCell("Values", 10)));

        Settings.logs.write("productAndPrice map is: " + productAndPrice);

        // adding least expensive product with 'Aloe' to the basket
        CommonTestUtil.addLeastExpensiveProductToCart(
                getPage(MoisturizerPage.class).getLblMoisturizerAloePrices(),
                getPage(MoisturizerPage.class).getBtnAddMoisturizer());

        // adding least expensive product with 'Almond' to the basket
        CommonTestUtil.addLeastExpensiveProductToCart(
                getPage(MoisturizerPage.class).getLblMoisturizerAlmondPrices(),
                getPage(MoisturizerPage.class).getBtnAddMoisturizerAlmond());

        getPage(MoisturizerPage.class).getBtnWithText().click();

        // Checking if '/cart' page is opened
        Assert.assertTrue(CommonTestUtil.getUrl().contains(
                ExcelUtil.readCell("Urls", 4)), "cart URL is not correct");
        Assert.assertTrue(getPage(CartPage.class).getLblTotalPrice().isDisplayed(),
                "Cart page is not opened");

        // Comparing LinkedHashMap with List<WebElement>
        List<WebElement> cartItemNames = getPage(CartPage.class).getLblCartItemName();
        List<WebElement> cartItemPrices = getPage(CartPage.class).getLblCartItemPrice();
        Settings.logs.write("Map size: " + productAndPrice.size());
        Settings.logs.write("webelement size: " + cartItemNames.size());
        Settings.logs.write("webelement size: " + cartItemPrices.size());
        Assert.assertEquals(productAndPrice.size(), cartItemNames.size(),
                "Product size is not matching");
        Assert.assertEquals(productAndPrice.size(), cartItemPrices.size(),
                "Product size is not matching");

        // Calculating total price and asserting
        String firstPrice = getPage(CartPage.class).getLblFirstProductPrice().getText();
        String secondPrice = getPage(CartPage.class).getLblSecondProductPrice().getText();
        String totalPrice = getPage(CartPage.class).getLblTotalPrice().getText()
                .replaceAll("[^0-9]", "");
        BigDecimal total = CommonTestUtil.bigDecimalAddition(
                CommonTestUtil.convertStringToBigDecimal(firstPrice),
                CommonTestUtil.convertStringToBigDecimal(secondPrice));
        Assert.assertEquals(CommonTestUtil.convertStringToBigDecimal(totalPrice), total,
                "total price is not equal");

        // Fill payment details
        getPage(CartPage.class).fillPaymentDetails(
                ExcelUtil.readCell("Values", 2),
                ExcelUtil.readCell("Values", 3),
                ExcelUtil.readCell("Values", 4),
                ExcelUtil.readCell("Values", 5),
                ExcelUtil.readCell("Values", 6)
        );

        // Verifying the confirmation page
        Assert.assertEquals(getPage(ConfirmationPage.class).getLblCartHeader().getText(),
                ExcelUtil.readCell("Values", 7),
                "Confirmation header page is not matched");
        Assert.assertEquals(getPage(ConfirmationPage.class).getLblSuccessMessage().getText(),
                ExcelUtil.readCell("Values", 8),
                "Success message is not shown");
        Assert.assertTrue(CommonTestUtil.getUrl().contains(
                ExcelUtil.readCell("Urls", 5)), "Confirmation URL is not correct");

    }

    @Test(dependsOnMethods = {"testFetchTemperature"}, priority = 2)
    public void testBuySunscreensProducts() throws InterruptedException {

        // Checking if temperature is greater than 19 degrees
        if (!(temperature > 19)) {
            throw new SkipException("Skipping the test case");
        }

        // Creating LinkedHashMap to store the product name and price
        Map<String, BigDecimal> productAndPrice = new LinkedHashMap<>();

        getPage(HomePage.class).getBtnBuySunscreens().click();

        // Storing the least expensive product with 'SPF-50'
        productAndPrice.putAll(CommonTestUtil.getLeastExpensiveProduct(
                getPage(SunscreensPage.class).getLblSunscreensNames(),
                getPage(SunscreensPage.class).getLblSunscreensPrices(),
                getPage(SunscreensPage.class).getBtnAdd(), "SPF-50"));

        // Storing the least expensive product with 'SPF-30'
        productAndPrice.putAll(CommonTestUtil.getLeastExpensiveProduct(
                getPage(SunscreensPage.class).getLblSunscreensNames(),
                getPage(SunscreensPage.class).getLblSunscreensPrices(),
                getPage(SunscreensPage.class).getBtnAdd(), "SPF-30"));

        Settings.logs.write("productAndPrice map is: " + productAndPrice);

        // adding least expensive product with 'SPF-50' to the basket
        CommonTestUtil.addLeastExpensiveProductToCart(
                getPage(SunscreensPage.class).getLblSunscreensSPF50Prices(),
                getPage(SunscreensPage.class).getBtnAddSunscreens());

        // adding least expensive product with 'SPF-30' to the basket
        CommonTestUtil.addLeastExpensiveProductToCart(
                getPage(SunscreensPage.class).getLblSunscreensSPF30Prices(),
                getPage(SunscreensPage.class).getBtnAddSunscreensSpf30());
        getPage(SunscreensPage.class).getBtnWithText().click();

        // Checking if '/cart' page is opened
        Assert.assertTrue(CommonTestUtil.getUrl().contains(
                ExcelUtil.readCell("Urls", 4)), "cart URL is not correct");
        Assert.assertTrue(getPage(CartPage.class).getLblTotalPrice().isDisplayed(),
                "Cart page is not opened");

        // Comparing LinkedHashMap with List<WebElement>
        List<WebElement> cartItemNames = getPage(CartPage.class).getLblCartItemName();
        List<WebElement> cartItemPrices = getPage(CartPage.class).getLblCartItemPrice();
        Settings.logs.write("Map size: " + productAndPrice.size());
        Settings.logs.write("webelement size: " + cartItemNames.size());
        Settings.logs.write("webelement size: " + cartItemPrices.size());
        Assert.assertEquals(productAndPrice.size(), cartItemNames.size(),
                "Product size is not matching");
        Assert.assertEquals(productAndPrice.size(), cartItemPrices.size(),
                "Product size is not matching");

        // Calculating total price and asserting
        String firstPrice = getPage(CartPage.class).getLblFirstProductPrice().getText();
        String secondPrice = getPage(CartPage.class).getLblSecondProductPrice().getText();
        String totalPrice = getPage(CartPage.class).getLblTotalPrice().getText()
                .replaceAll("[^0-9]", "");
        BigDecimal total = CommonTestUtil.bigDecimalAddition(
                CommonTestUtil.convertStringToBigDecimal(firstPrice),
                CommonTestUtil.convertStringToBigDecimal(secondPrice));
        Assert.assertEquals(CommonTestUtil.convertStringToBigDecimal(totalPrice), total,
                "total price is not equal");

        // Fill payment details
        getPage(CartPage.class).fillPaymentDetails(
                ExcelUtil.readCell("Values", 2),
                ExcelUtil.readCell("Values", 3),
                ExcelUtil.readCell("Values", 4),
                ExcelUtil.readCell("Values", 5),
                ExcelUtil.readCell("Values", 6)
        );

        // Verifying the confirmation page
        Assert.assertEquals(getPage(ConfirmationPage.class).getLblCartHeader().getText(),
                ExcelUtil.readCell("Values", 7),
                "Confirmation header page is not matched");
        Assert.assertEquals(getPage(ConfirmationPage.class).getLblSuccessMessage().getText(),
                ExcelUtil.readCell("Values", 8),
                "Success message is not shown");
        Assert.assertTrue(CommonTestUtil.getUrl().contains(
                ExcelUtil.readCell("Urls", 5)), "Confirmation URL is not correct");
    }

}
