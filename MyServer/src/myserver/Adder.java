import java.rmi.*;
public interface Adder extends Remote{
public int delexp(int x,int y) throws RemoteException;
public int addinc(int x, int y) throws RemoteException;
public String[] dbconn(int id) throws RemoteException;

}
