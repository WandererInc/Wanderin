package org.wanderin.net;

import org.wanderin.Wanderin;
import org.wanderin.utils.Logger;

import java.io.*;
import java.net.Socket;

public class Handle extends Thread {
    private Socket socket = null;
    public Handle(Socket socket) {
        this.socket = socket;
    }

    private void send(String msg) throws IOException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.println(msg);
    }

    @Override
    public void run() {
        new Logger(0,"Client", socket.getRemoteSocketAddress().toString(),"connected.");
        synchronized (Wanderin.connections) {
            Wanderin.connections.add(new Connection(socket));
        }
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("[Client Msg]-------------------------->" + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
