package calculatorServer;

import calculatorInterface.Calculation;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculationImpl extends UnicastRemoteObject
        implements Calculation{
  public CalculationImpl() throws RemoteException {
        //needed because of remote excpetion
    }

    public String compute (String number1, String number2, String operation) throws RemoteException {
        int num1=0, num2=0;
        String result;
        try {
            num1 = Integer.parseInt(number1);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("\"" + number1 + "\" is invalid format.");
        }
        try {
            num2 = Integer.parseInt(number2);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("\"" + number2 + "\" is invalid format.");
        }
        switch (operation) {
            case "+":
                result = Integer.toString(num1 + num2);
                break;
            case "-":
                result = Integer.toString(num1 - num2);
                break;
            case "*":
                result = Integer.toString(num1 * num2);
                break;
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Number 2 must not be zero in division");
                }
                result = Integer.toString(num1 / num2);
                break;
            default:
                throw new IllegalArgumentException("Operation invalid");
        }
        return result;
    }

}
