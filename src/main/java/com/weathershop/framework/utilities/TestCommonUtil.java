package com.weathershop.framework.utilities;

import com.weathershop.framework.base.DriverContext;
import org.openqa.selenium.WebElement;

public class TestCommonUtil {

    public static String getUrl() {
        return DriverContext.getDriver().getCurrentUrl();
    }

    public static int removeDegreeAndConvertToNumber(WebElement element) {
        String one[] = element.getText().split(" ");
        return Integer.parseInt(one[0]);
    }
}
