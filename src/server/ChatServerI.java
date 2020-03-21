package server;

import client.ChatClientI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerI extends Remote {

    void registerChatClient(ChatClientI chatClient) throws RemoteException;

    void broadcastMessage(String message) throws RemoteException;
}
