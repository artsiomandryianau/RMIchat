package server;

import client.ChatClientI;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServer extends UnicastRemoteObject implements ChatServerI {

    private static final long serialVersionUID = 1l;
    private ArrayList<ChatClientI> chatClients;
    public ChatServer() throws RemoteException {
        super();
    }

    public synchronized void registerChatClient(ChatClientI chatClient) throws RemoteException {
        this.chatClients.add(chatClient);
    }

    public void broadcastMessage(String message) throws RemoteException {
        for(int i = 0; i< chatClients.size(); i++){
            chatClients.get(i).retrieveMessage(message);
        }

    }
}
