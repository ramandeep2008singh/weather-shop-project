package com.weathershop.test.test;

import com.weathershop.framework.utilities.ExcelUtil;
import com.weathershop.framework.utilities.TestCommonUtil;
import com.weathershop.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends TestInitializer {

    @Test
    public void testHeader() {
        Assert.assertTrue(getPage(HomePage.class).getLblHeader().isDisplayed(),
                "Header is not present");
    }

    @Test
    public void testURLIsCorrect() {
        Assert.assertEquals(TestCommonUtil.getUrl(),
                ExcelUtil.readCell("Urls", 1), "URL is not correct");
    }

    @Test
    public void testToolTipIsPresent() {
        Assert.assertTrue(getPage(HomePage.class).getToolTipInfoIcon().isDisplayed(),
                "Tool-tip is not present");
    }

    @Test
    public void testTempratureSectionIsPresent() {
        Assert.assertTrue(getPage(HomePage.class).getPanelTemprature().isDisplayed(),
                "Temprature section is not present");
    }

    @Test
    public void testMoisturizersSecionIsPresent() {
        Assert.assertTrue(getPage(HomePage.class).getPanelMoisturizers().isDisplayed(),
                "Moisturizers panel is not present");
    }

    @Test
    public void testSunscreensSectionIsPresent() {
        Assert.assertTrue(getPage(HomePage.class).getPanelSunscreens().isDisplayed(),
                "Sunscreens panel is not present");
    }

    @Test
    public void testTempratureIsPresent() {
        Assert.assertTrue(getPage(HomePage.class).getLblTempratureText().isDisplayed(),
                "Temprature is not present");
    }

}
