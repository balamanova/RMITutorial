package chatinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClient  extends Remote {
    public void addMessage(String message)  throws RemoteException;
    
    public void connect(String username)  throws RemoteException;
    
    public void disconnect(String username) throws RemoteException;
    
    public void sendMessage(String username, String message) throws RemoteException;
}
