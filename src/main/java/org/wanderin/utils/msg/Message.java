package org.wanderin.utils.msg;

import org.wanderin.utils.json.JsonUtils;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private String fromUser = null;
    private String toUser = null;
    private String MsgTxt = null;
    private Long MsgTime = System.currentTimeMillis();
    public Message(String fromUser, String toUser, String MsgTxt) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.MsgTxt = MsgTxt;
    }
    public Message(String fromUser, String toUser, String MsgTxt, Long MsgTime) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.MsgTxt = MsgTxt;
        this.MsgTime = MsgTime;
    }
    public String toJSON() {
        Map<String, String> msg = new HashMap<>();
        msg.put("from", fromUser);
        msg.put("to", toUser);
        msg.put("msg", MsgTxt);
        msg.put("time", MsgTime.toString());
        return JsonUtils.JSONCreator(msg);
    }
}
