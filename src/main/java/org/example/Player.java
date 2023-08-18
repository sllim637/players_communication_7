package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Player implements Serializable {

    private static final int MAX_MESSAGE_TO_SEND = 10;
    private final String name;
    private Integer sentMessageCount;
    private final Socket socket;

    public Player(String name, Socket socket) {
        this.name = name;
        this.sentMessageCount = 0;
        this.socket = socket;
    }

    public void sendMessage(String content) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());
        System.out.println(this.name + " send message " + content + "...");
        out.writeObject(content);
        if (sentMessageCount < MAX_MESSAGE_TO_SEND) {
            this.receiveMessage();
        }
    }

    public void receiveMessage() throws IOException {
        ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());

        try {
            String message = (String) in.readObject();
            System.out.println(this.name + " receive message : " + message);
            this.sentMessageCount++;

            this.sendMessage("message " + sentMessageCount);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
