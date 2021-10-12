package com.weathershop.test.test;

import com.weathershop.framework.config.Settings;
import com.weathershop.framework.utilities.TestCommonUtil;
import com.weathershop.test.pages.HomePage;
import com.weathershop.test.pages.SunscreensPage;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class CheckoutTests extends TestInitializer {

    private static int temperature;

    @Test(priority = 1)
    public void testFetchTemperature() {
        getPage(HomePage.class);
        temperature = TestCommonUtil.removeDegreeAndConvertToNumber(
                getPage(HomePage.class).getLblTempratureText());
        if (temperature < 19) {
            Settings.logs.write("--- Buying Moisturizers ---");
        } else {
            Settings.logs.write("--- Buying Sunscreens ---");
        }
    }

    @Test(dependsOnMethods = {"testFetchTemperature"}, priority = 2)
    public void testBuyMoisturizers() {
        if (!(temperature < 19)) {
            throw new SkipException("Skipping the test case");
        }

    }

    @Test// (dependsOnMethods = {"testFetchTemperature"}, priority = 2)
    public void testBuySunscreens() {
        /*if (!(temperature > 19)) {
            throw new SkipException("Skipping the test case");
        }*/
        getPage(HomePage.class).getBtnBuySunscreens().click();
        getPage(SunscreensPage.class).getLeastExpensiveSPF_50Sunscreen();
    }

}
