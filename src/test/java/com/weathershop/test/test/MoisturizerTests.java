package com.weathershop.test.test;

import com.weathershop.framework.utilities.CommonTestUtil;
import com.weathershop.framework.utilities.ExcelUtil;
import com.weathershop.test.pages.HomePage;
import com.weathershop.test.pages.MoisturizerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoisturizerTests extends TestInitializer {

    @Test(priority = 1)
    public void testNavigateToMoisturizerPage() {
        getPage(HomePage.class).clickOnBuyMoisturizer();
    }

    @Test(priority = 2)
    public void testUrlOnMoisturizerPage() {
        Assert.assertEquals(CommonTestUtil.getUrl(),
                ExcelUtil.readCell("Urls", 6),
                "Moisturizer page is not opened");
    }

    @Test(priority = 2)
    public void testHeader() {
        Assert.assertEquals(getPage(MoisturizerPage.class).getLblMoisturizerHeader().getText(),
                ExcelUtil.readCell("Values", 13),
                "Header is not matched");
    }

    @Test(priority = 2)
    public void testToolTip() {
        Assert.assertTrue(getPage(MoisturizerPage.class).getToolTipMoisturizerInfoIcon().isDisplayed(),
                "Tool-tip info icon is not present");
    }

}
