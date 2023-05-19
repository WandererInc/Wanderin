package org.wanderin.utils.config;

import org.wanderin.utils.Logger;
import org.wanderin.utils.json.JsonUtils;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class ConfigReader {
    public static int PORT = 8080;
    public static boolean DEBUG = true;
    public static class Database {
        public static String addr = "127.0.0.1";
        public static int port = 3306;
        public static String username = "root";
        public static String passwd = "root";
        public static String dbname = "wanderin";
    }
    static {
        //日你妈了隔壁的我又拉肚子了 2023.5.18 10:31
        try {
            var config = JsonUtils.JsonReader(new File("config.json"));
            PORT = Integer.parseInt((String) config.get("serverPort"));
            DEBUG = ((String) config.get("debug")).equals("true") ? true : false;
            Database.addr = (String) config.get("dbAddr");
            Database.port = Integer.parseInt((String) config.get("dbPort"));
            Database.username = (String) config.get("dbUser");
            Database.passwd = (String) config.get("dbPwd");
            Database.dbname = (String) config.get("dbName");
        } catch (Exception e) {
            new Logger(2,"Can't read config.json, using default...");
        }
    }
}
