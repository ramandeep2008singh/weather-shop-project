package com.weathershop.test.test;

import com.weathershop.framework.utilities.CommonTestUtil;
import com.weathershop.framework.utilities.ExcelUtil;
import com.weathershop.test.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends TestInitializer {

    @Test(priority = 1)
    public void testNavigateToCartPge() {
        getPage(CartPage.class).navigateToCartPage();
    }

    @Test(priority = 2)
    public void testHeaderOnCart() {
        Assert.assertEquals(getPage(CartPage.class).getLblCartHeader().getText(),
                ExcelUtil.readCell("Values", 15),
                "Checkout header is not matching");
    }

    @Test(priority = 2)
    public void testUrlOnCartPage() {
        Assert.assertEquals(CommonTestUtil.getUrl(),
                ExcelUtil.readCell("Urls", 8),
                "Cart page is not opened");
    }

    @Test(priority = 2)
    public void testToolTip() {
        Assert.assertTrue(getPage(CartPage.class).getToolTipCartInfoIcon().isDisplayed(),
                "Tool-tip info icon is not present");
    }

    @Test(priority = 2)
    public void testPayWithCardBtnIsPresent() {
        Assert.assertTrue(getPage(CartPage.class).getBtnPayWithCard().isDisplayed(),
                "Pay With Card button is not present");
    }


}
