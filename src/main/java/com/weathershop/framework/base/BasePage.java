package com.weathershop.framework.base;

import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public <TPage extends BasePage> TPage getPage(Class<TPage> page) {
        Object obj = PageFactory.initElements(DriverContext.getDriver(), page);
        return page.cast(obj);
    }

}
