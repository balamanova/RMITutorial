package calculatorInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculation extends Remote{
     public String compute(String number1, String number2, String operation) throws RemoteException;
}
