package com.weathershop.framework.utilities;

import com.weathershop.framework.config.Settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    // logging name
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HHMMSS");
    String fileNameFormat = date.format(formatter);

    private BufferedWriter bufferedWriter = null;

    // create log file
    public void createLogFile() {
        try {
            var dir = new File(Settings.logPath);
            if (!dir.exists())
                dir.mkdir();
            // create file
            var logFile = new File(dir + "/" + fileNameFormat + ".log");
            var fileWriter = new FileWriter(logFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // write message
    public void write(String message) {
        try {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");
            var dateFormat = date.format(formatter);

            bufferedWriter.write("[" + dateFormat + "]: " + message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
