package com.weathershop.framework.config;

import com.weathershop.framework.base.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void readConfig() throws IOException {
        var reader = new ConfigReader();
        reader.readProperty();
    }

    private void readProperty() throws IOException {
        //Create Property Object
        var properties = new Properties();
        //Load the Property file available in same package
        var inputStream = new FileInputStream(
                "src/main/java/com/weathershop/framework/config/GlobalConfig.properties");
        properties.load(inputStream);

        // Get LogPath
        Settings.logPath = properties.getProperty("LogPath");
        // Get Excel sheet path
        Settings.excelSheetPath = properties.getProperty("ExcelSheetPath");
        // Get Application URL
        Settings.AUT = properties.getProperty("AUT");
        // Get Browser type
        Settings.browserType = BrowserType.valueOf(properties.getProperty("BrowserType"));
        // Get Selenium grid URL
        Settings.seleniumGridHub = properties.getProperty("SeleniumGridHub");
        // Get Video Path
        Settings.videoPath = properties.getProperty("VideoPath");
        // Get env
        Settings.environment = properties.getProperty("Environment");
    }

}
