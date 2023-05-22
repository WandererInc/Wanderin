package org.wanderin.utils.msg;

import org.wanderin.Wanderin;
import org.wanderin.utils.Logger;
import org.wanderin.utils.json.JsonUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

public class MsgUtils {
    public static void MsgNotify(String plainTxt) {
        MsgNotify(MsgRecv(plainTxt));
    }
    public static void MsgNotify(Message message) {
        var msg = message.toMap();
        if (msg.get("to") != null && !msg.get("from").equals("")) {
            new Logger(0, "Sending message to", msg.get("to"), "\nMessage:\n", msg.get("msg"));
            synchronized (Wanderin.connections) {
                Wanderin.connections.forEach((connection) -> {
                    new Logger(0, connection.getUser().getUsername());
                    if (connection.getUser() != null && connection.getUser().getUsername().equals(msg.get("to"))) {
                        try {
                            PrintWriter writer = new PrintWriter(new OutputStreamWriter(connection.getSocket().getOutputStream()));
                            writer.println(JsonUtils.JSONCreator(msg));
                            writer.flush();
                            new Logger(0, "Message sent to", msg.get("to"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        }
    }
    public static Message MsgRecv(String json) {
        Map map = JsonUtils.JsonReader(json);
        try {
            switch(map.get("type").toString()) {
                case "dm":
                    System.out.println("DM"); break;
                case "setuname":
                    System.out.println("Set Username: " + map.get("user")); break;
                default:
                    System.out.println("Unhandled Packet");
            }
        } catch (Exception e) {}
        try {
            var msg = new Message(
                    (String) map.get("from"), (String) map.get("to"), (String) map.get("msg"), Long.valueOf((String) map.get("time"))
            );
            //我是人才（确信
            //刚刚debug半天看着都是null
            //结果发现4个都打错了
            //就是这里呜呜

            //TODO
            //Add to database

            new Logger(0, msg.toString());
            MsgNotify(msg);
            return msg;
        } catch (Exception e) {
            return null;
        }
    }
}
