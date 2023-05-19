package org.wanderin.utils.msg;

public class MsgHandle {
    private Message message = null;
    private boolean isCmd = false;

    public MsgHandle(Message message) {
        this.message = message;
        if (message.toMap().get("msg").toString().startsWith("/")) this.isCmd = true;
        if (message.toMap().get("to") != null) {
            //TODO send message
        }
    }

    public void sendMsg() {
        MsgUtils.MsgNotify(message);
    }
}
