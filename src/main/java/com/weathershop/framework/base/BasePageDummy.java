package com.weathershop.framework.base;

public abstract class BasePageDummy extends BasePage {

    public <TPage extends BasePageDummy> TPage as(Class<TPage> pageInstance) {
        try {
            return (TPage)this;
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

}

