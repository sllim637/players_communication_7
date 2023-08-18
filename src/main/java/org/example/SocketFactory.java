package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketFactory {
    private static final int PORT = 12345;
    private static final String HOST = "localhost";
    private static ServerSocket serverSocket;
    private static Socket socket;

    public static ServerSocket createServerSocket() throws IOException {
        if (serverSocket == null) {
            SocketFactory.serverSocket = new ServerSocket(PORT);
        }
        return serverSocket;
    }

    public static Socket createSocket() throws IOException {
        if (socket == null) {
            socket = new Socket(HOST, PORT);
        }
        return socket;
    }

}
