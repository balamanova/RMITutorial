package calculatorServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class CalculatorServer {
     public static void main(String[] args) {
        try {
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
            r.rebind("CalculationImpl", (Remote) new CalculationImpl());
            System.out.println("Server is connected and ready for operation.");
        } catch (RemoteException e) {
            System.out.println("Server not connected: " + e);
        }
    }
}
