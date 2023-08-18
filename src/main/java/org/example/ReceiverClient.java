package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverClient {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =  SocketFactory.createServerSocket();
        Socket socket = serverSocket.accept();
        Player receiver = new Player("omar", socket);

        receiver.receiveMessage();
        socket.close();
        serverSocket.close();

    }
}
