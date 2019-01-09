package shopInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import shopServer.Persistence;

public interface ProductInfo extends Remote {
    public List<Product> findProducts(String searchString) throws RemoteException;

    public List<Product> findProductsByTitle(String searchString) throws RemoteException;

    public List<Product> findProductsByPerson(String searchString)throws RemoteException;

    public List<Product> findBooks(String searchString) throws RemoteException;

    public List<Product> findBooksByTitle(String searchString) throws RemoteException;

    public List<Product> findBooksByPerson(String searchString) throws RemoteException;

    public List<Product> findFilms(String searchString) throws RemoteException;

    public List<Product> findFilmsByTitle(String searchString) throws RemoteException;

    public List<Product> findFilmsByPerson(String searchString) throws RemoteException;
}
