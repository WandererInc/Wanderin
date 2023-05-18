package org.wanderin.net;

import org.wanderin.data.User;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
    private Socket socket = null;
    private User user = null;
    private Long lastBiDongTime;
    public Connection(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getLastBiDongTime() {
        return lastBiDongTime;
    }

    public void setLastBiDongTime(Long lastBiDongTime) {
        this.lastBiDongTime = lastBiDongTime;
    }

}
