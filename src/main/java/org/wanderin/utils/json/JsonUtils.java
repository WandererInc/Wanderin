package org.wanderin.utils.json;

import org.wanderin.utils.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {
    public static Map JsonReader(File file) {
        String encoding = "utf-8";
        try {
            if (file.isFile() && file.exists()) {
                InputStreamReader inputStreamReader = new InputStreamReader(
                        new FileInputStream(file),encoding
                );
                /*
                * 今天早上做梦梦到小小泽了
                * 那孩子还是那么可爱
                * 还很乖
                */
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = null;
                Map<String, String> jsonMap = new HashMap<>();
                String result = "";
                String key, value = null;
                while ((line = bufferedReader.readLine()) != null) {
                    Pattern pattern = Pattern.compile("\\s*|\t|\r|\n"); //去掉空白字符
                    Matcher matcher = pattern.matcher(line);
                    line = matcher.replaceAll("");
                    try {
                        key = line.split(":")[0].replace("\"", "");
                        value = line.split(":")[1].replace("\"", "");
                        value = value.replace(",","");
                        jsonMap.put(key, value);
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
                }
                return jsonMap;
            } else {
                new Logger(2,"file", file.getName(), "not found");
            }
        } catch (IOException e) {
            new Logger(3,"Can't read file", file.getName());
        }
        return null;
    }
    public static Map JsonReader(String jsonPath) {
        String encoding = "utf-8";
        try {
            File file = new File(jsonPath);
            if (file.isFile() && file.exists()) {
                InputStreamReader inputStreamReader = new InputStreamReader(
                        new FileInputStream(file),encoding
                );
                /*
                 * 今天早上做梦梦到小小泽了
                 * 那孩子还是那么可爱
                 * 还很乖
                 */
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = null;
                Map<String, String> jsonMap = new HashMap<>();
                String result = "";
                String key, value = null;
                while ((line = bufferedReader.readLine()) != null) {
                    Pattern pattern = Pattern.compile("\\s*|\t|\r|\n"); //去掉空白字符
                    Matcher matcher = pattern.matcher(line);
                    line = matcher.replaceAll("");
                    try {
                        key = line.split(":")[0].replace("\"", "");
                        value = line.split(":")[1].replace("\"", "");
                        value = value.replace(",","");
                        jsonMap.put(key, value);
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
                }
                return jsonMap;
            } else {
                new Logger(2,"file", jsonPath, "not found");
            }
        } catch (IOException e) {
            new Logger(3,"Can't read file", jsonPath);
        }
        return null;
    }

}
