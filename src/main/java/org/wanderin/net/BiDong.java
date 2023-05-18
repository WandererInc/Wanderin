package org.wanderin.net;

import java.net.Socket;

public class BiDong extends Thread {
    private Socket socket;
    public BiDong(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {}
}
