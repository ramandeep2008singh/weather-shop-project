package com.weathershop.test.test;

import com.weathershop.framework.utilities.CommonTestUtil;
import com.weathershop.framework.utilities.ExcelUtil;
import com.weathershop.test.pages.HomePage;
import com.weathershop.test.pages.SunscreensPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SunscreensTests extends TestInitializer {

    @Test(priority = 1)
    public void testNavigateToMoisturizerPage() {
        getPage(HomePage.class).clickOnBuySunscreens();
    }

    @Test(priority = 2)
    public void testUrlOnSunscreensPage() {
        Assert.assertEquals(CommonTestUtil.getUrl(),
                ExcelUtil.readCell("Urls", 7),
                "Sunscreens page is not opened");
    }

    @Test(priority = 2)
    public void testHeader() {
        Assert.assertEquals(getPage(SunscreensPage.class).getLblSunscreenHeader().getText(),
                ExcelUtil.readCell("Values", 14),
                "Header is not matched");
    }

    @Test(priority = 2)
    public void testToolTip() {
        Assert.assertTrue(getPage(SunscreensPage.class).getToolTipSunscreenInfoIcon().isDisplayed(),
                "Tool-tip info icon is not present");
    }
}
