package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientI extends Remote {

    void retrieveMessage(String message) throws RemoteException;
}
