package org.wanderin.net;

import org.wanderin.Wanderin;
import org.wanderin.utils.Logger;

import java.net.Socket;

public class Handle extends Thread {
    private Socket socket = null;
    public Handle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        new Logger(0,"Client", socket.getRemoteSocketAddress().toString(),"connected.");
        synchronized (Wanderin.connections) {
            Wanderin.connections.add(new Connection(socket));
        }
    }
}
