package chatserver;

import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import chatinterface.ChatClient;
import java.util.HashMap;
import java.util.Map;
import chatclient.ChatClientUI;
import chatinterface.ChatServer;

public class ChatServerImpl extends UnicastRemoteObject implements ChatServer {

    private final Map<String, ChatClient> clientMap = new HashMap<>();

    public ChatServerImpl() throws RemoteException {

    }

    @Override
    public void connect(String username, ChatClient client) throws RemoteException {
        sendMessageToAll("New user: " + username);
        clientMap.put(username, client);
    }

    @Override
    public void disconnect(String username) throws RemoteException {
        clientMap.remove(username);
        sendMessageToAll("User is gone: " + username);
    }

    @Override
    public void sendMessage(String username, String message) throws RemoteException {
        sendMessageToAll(username + ": " + message);
    }

    @Override
    public void sendMessageToAll(String message) throws RemoteException {
       for (ChatClient client: clientMap.values()) {
           client.addMessage(message);
        }
    }

}
