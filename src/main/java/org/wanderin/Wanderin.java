package org.wanderin;

import org.wanderin.net.Connection;
import org.wanderin.net.Handle;
import org.wanderin.utils.Logger;
import org.wanderin.utils.config.ConfigReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class Wanderin {
    public static final List<Connection> connections = new Vector<>();
    public static void main(String[] args) {
        // Just works for you
        new Logger(1,"Just works on you, works for you");
        new Logger(1,"应用程序工作目录：",System.getProperty("user.dir"));
        //读取config.json
        ConfigReader configReader = new ConfigReader();
        //就是玩一玩不要介意了啦
        new Logger(0,"Debug mode is enabled");
        new Logger(0,"Database Information\n",
                "===================================================",
                "\nDatabase address: ", ConfigReader.Database.addr,
                "\nDatabase port: ", Integer.toString(ConfigReader.Database.port),
                "\nDatabase username: ", ConfigReader.Database.username,
                "\nDatabase password: ", ConfigReader.Database.passwd,
                "\nDatabase name:", ConfigReader.Database.dbname,
                "\n==================================================="
        );

        //启动服务器
        try {
            new Logger(1,"Starting server on ", Integer.toString(ConfigReader.PORT));
            ServerSocket serverSocket = new ServerSocket(ConfigReader.PORT);
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                Thread thread = new Handle(socket);
                thread.start();
            }
        } catch (IOException e) {
            new Logger(0,"Can't start server");
        }
    }
}