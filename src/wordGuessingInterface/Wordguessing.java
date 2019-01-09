package wordGuessingInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Wordguessing extends Remote {

    public String getLetters()  throws RemoteException;

    public String guessWord(String guess)  throws RemoteException;
}
