package wordGuessingServer;

import calculatorServer.CalculationImpl;
import java.rmi.Remote;
import java.rmi.registry.Registry;

public class WordGuessingServer {
    
     public static void main(String[] args) {
        try {
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
            r.rebind("WordguessingImpl", (Remote) new WordguessingImpl());
            System.out.println("Server is connected and ready for operation.");
        } catch (Exception e) {
            System.out.println("Server not connected: " + e);
            e.printStackTrace();
        }
    }
}
    