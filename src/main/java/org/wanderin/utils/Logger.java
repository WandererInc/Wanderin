package org.wanderin.utils;

import org.wanderin.utils.config.ConfigReader;

import java.text.SimpleDateFormat;

public class Logger {
    private StringBuilder logMsg = new StringBuilder();
    private int logLevel;
    public static boolean debugLevel = ConfigReader.DEBUG;
    public static String getColoredString(int color, String string) {
        color = 31 + color;
        int fontType = 2;
        return String.format("\033[%d;%dm%s\033[0m", color,fontType,string);
    }
    public Logger(int logLevel, String... log) {
        int color = 0;
        switch (logLevel) {
            case 1:
                color = 1;
                logMsg.append(getColoredString(color, "[Info] "));
                break;
            case 2:
                color = 2;
                logMsg.append(getColoredString(color, "[Warning] "));
                break;
            case 3:
                color = 0;
                logMsg.append(getColoredString(color, "[Error] "));
                break;
            case 0:
                if (debugLevel) {
                    color = 3;
                    logMsg.append(getColoredString(color, "<<<DEBUG>>> "));
                } else {
                    return;
                }
                break;
        }
        logMsg.append(getColoredString(color, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())));
        logMsg.append(getColoredString(color, " ==> "));
        for (String str : log) {
            this.logMsg.append(getColoredString(color, str));
            this.logMsg.append(" ");
        }
        this.output();
    }

    private void output() {
        System.out.println(this.logMsg);
    }

}
