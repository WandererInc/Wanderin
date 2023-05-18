package org.wanderin;

import org.wanderin.utils.json.JsonUtils;
import org.wanderin.utils.msg.Message;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String json = """
                      {
                        "key1": "value1",
                        "key2": "value2"
                      }
                      """;
        JsonUtils.JsonReader(json);

        System.out.println(new Message("admin", "root", "test").toJSON());
        System.out.println(new Message("admin", "root", "test", 114514L).toJSON());
    }
}
