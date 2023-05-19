package org.wanderin.utils.msg;

import org.wanderin.utils.Logger;
import org.wanderin.utils.json.JsonUtils;

import java.util.Map;

public class MsgUtils {
    public static void MsgSend(String plainTxt) {
        //fromUser=XXX,toUser=XXX,Msg=
    }
    public static Message MsgRecv(String json) {
        Map map = JsonUtils.JsonReader(json);
        var msg = new Message(
                (String) map.get("from"), (String) map.get("to"), (String) map.get("msg"), Long.valueOf((String) map.get("time"))
        );
        //我是人才（确信
        //刚刚debug半天看着都是null
        //结果发现4个都打错了
        //就是这里呜
        new Logger(0, msg.toString());
        return msg;
    }
}
