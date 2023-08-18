package org.example;

import java.io.*;
import java.net.*;

public class SenderClient {
    public static void main(String[] args) throws IOException {
        Socket socket = SocketFactory.createSocket();
        Player sender = new Player("slim", socket);
        sender.sendMessage("Hello");
        socket.close();
    }
}