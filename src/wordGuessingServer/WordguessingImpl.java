package wordGuessingServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Random;
import wordGuessingInterface.Wordguessing;

public class WordguessingImpl extends UnicastRemoteObject
        implements Wordguessing{

    private final String[] wordlist = {"computer", "system", "java", "socket", "distributed"};
    private String actualWord;
    private boolean gameOver;

    public WordguessingImpl() throws RemoteException {
        int i = new Random().nextInt(wordlist.length);
        actualWord = wordlist[i];
        gameOver = false;
    }

    @Override
    public String getLetters() {
        if (gameOver) {
            int i = new Random().nextInt(wordlist.length);
            actualWord = wordlist[i];
            gameOver = false;
        }
        char[] letters = actualWord.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
    
    @Override
    public String guessWord(String guess) {
        if (gameOver){
            return "You must ask for new letters.";
        }
        System.out.println("acutal Word: <" + actualWord + ">");
        System.out.println("guess: <" + guess + ">");
        if (guess.equalsIgnoreCase(actualWord)){
            gameOver = true;
            return "Gratulation. You have won. Ask for a new word.";
        }
        return "Sorry. This is not the correct word.";
    }
}
