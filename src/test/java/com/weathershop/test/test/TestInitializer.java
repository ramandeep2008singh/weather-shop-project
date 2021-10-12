package com.weathershop.test.test;

import com.weathershop.framework.base.DriverContext;
import com.weathershop.framework.base.FrameworkInitialize;
import com.weathershop.framework.config.ConfigReader;
import com.weathershop.framework.config.Settings;
import com.weathershop.framework.utilities.ExcelUtil;
import com.weathershop.framework.utilities.LogUtil;
import com.weathershop.framework.utilities.VideoRecorderUtil;
import com.weathershop.framework.utilities.WaitUtil;
import jxl.read.biff.BiffException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestInitializer extends FrameworkInitialize {

    @BeforeTest
    public void initialize(ITestContext ctx) throws InterruptedException, IOException, BiffException {

        // Initialize Config
        ConfigReader.readConfig();

        // Logging
        Settings.logs = new LogUtil();
        Settings.logs.createLogFile();

        // Initialize Browser
        Settings.logs.write("Initializing Browser");
        initializeBrowser(Settings.browserType);
        Settings.logs.write("Browser Initialized");
        DriverContext.goToUrl(Settings.AUT);
        Settings.logs.write("Navigated to: " + Settings.AUT);
        WaitUtil.waitForPageToLoad();

        // Initialize Excel util
        Settings.logs.write("Initializing ExcelUtil");
        ExcelUtil util = new ExcelUtil(Settings.excelSheetPath);
    }

    @AfterTest
    public void tearDown() {
        Settings.logs.write("Quitting the browser");
        DriverContext.getDriver().quit();
        Settings.logs.write("Browser is quitted");
    }

    @BeforeMethod
    public void beforeMethod(Method method) throws Exception {
        Settings.logs.write("Starting the video recording");
        VideoRecorderUtil.startRecording(method);
        Settings.logs.write("Video recording is done");
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Settings.logs.write("stopping the video recording");
        VideoRecorderUtil.stopRecording();
    }

}
