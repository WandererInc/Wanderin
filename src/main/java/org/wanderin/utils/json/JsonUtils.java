package org.wanderin.utils.json;

import com.google.gson.JsonStreamParser;
import org.wanderin.utils.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JsonUtils {

    //JSON文件读取
    public static Map JsonReader(File file) {
        String encoding = "utf-8";
        try {
            if (file.isFile() && file.exists()) {
                InputStreamReader inputStreamReader = new InputStreamReader(
                        new FileInputStream(file), encoding
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
                    line = Pattern.compile("\\s*|\t|\r|\n").matcher(line).replaceAll("");
                    try {
                        key = line.split(":")[0].replace("\"", "");
                        value = line.split(":")[1].replace("\"", "");
                        value = value.replace(",", "");
                        jsonMap.put(key, value);
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    }
                }
                return jsonMap;
            } else {
                new Logger(2, "file", file.getName(), "not found");
            }
        } catch (IOException e) {
            new Logger(3, "Can't read file", file.getName());
        }
        return null;
    }

    //JSON字符串读取
    public static Map JsonReader(String json) {
        String encoding = "utf-8";
        try {
            json = Pattern.compile("\\s*|\t|\r|\n").matcher(json).replaceAll("");
            json = Pattern.compile("[\\{\\}\\[\\]]").matcher(json).replaceAll("");
            Map<String, String> jsonMap = new HashMap<>();
            String key, value = null;
            for (String line : json.split(",")) {
                key = line.split(":")[0].replace("\"", "");
                value = line.split(":")[1].replace("\"", "");
                value = value.replace(",", "");
                jsonMap.put(key, value);
            }
            return jsonMap;
        } catch (Exception e) {
            new Logger(3, "Bad JSON style");
        }
        return null;
    }
    //JSON字符串生成
    public static String JSONCreator(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuilder.append("\"" + entry.getKey() + "\"" + ": \"" + entry.getValue() + "\",");
        }
        stringBuilder.append("}");
        int lastComma = stringBuilder.toString().lastIndexOf(",");
        stringBuilder.deleteCharAt(lastComma);
        return stringBuilder.toString();
    }
}
