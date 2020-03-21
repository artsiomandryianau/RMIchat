package client;
import server.ChatServerI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ChatClient extends UnicastRemoteObject implements ChatClientI, Runnable {
    private ChatServerI chatServer;
    private String name = null;

    protected ChatClient(String name, ChatServerI chatServer) throws RemoteException {
        this.name = name;
        this.chatServer = chatServer;
        chatServer.registerChatClient((ChatClientI) this);
    }

    @Override
    public void retrieveMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String message;
        message = sc.next();
        try{
            chatServer.broadcastMessage(message);
        } catch (RemoteException re){
            re.printStackTrace();
        }
    }
}
