package chatinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServer extends Remote{
    public void connect(String username, ChatClient client)  throws RemoteException;
     public void disconnect(String username)  throws RemoteException;
    public void sendMessage(String username, String message)  throws RemoteException;
    public void sendMessageToAll(String message)  throws RemoteException;
}
