package chatclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import chatinterface.ChatClient;
import chatinterface.ChatServer;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClient {

    private final ChatClientUI clientUI;
    ChatServer prod;
    
    public ChatClientImpl(ChatClientUI clientUI) throws RemoteException {
        super();
        this.clientUI = clientUI;
        try {
            prod = (ChatServer) Naming.lookup("//localhost/ChatServerImpl");
        } catch (NotBoundException ex) {
            Logger.getLogger(ChatClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChatClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addMessage(String message) {
        clientUI.addMessage(message);
    }

    public void connect(String username) throws RemoteException {
      
        prod.connect(username, this);
    }

    public void disconnect(String username) throws RemoteException {

        prod.disconnect(username);
    }

    public void sendMessage(String username, String message) throws RemoteException {
        prod.sendMessage(username, message);
    }
}
