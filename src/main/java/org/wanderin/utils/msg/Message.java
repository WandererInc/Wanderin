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
        return JsonUtils.JSONCreator(this.toMap());
    }
    public Map<String, String> toMap() {
        Map<String, String> msg = new HashMap<>();
        msg.put("from", fromUser);
        msg.put("to", toUser);
        msg.put("msg", MsgTxt);
        msg.put("time", MsgTime.toString());
        return msg;
    }

    @Override
    public String toString() {
        return String.format("[%s][%s] -> [%s] : %s", (this.MsgTime == null? 0 : this.MsgTime), this.fromUser, this.toUser, this.MsgTxt);
    }
}
