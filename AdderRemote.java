import java.rmi.*;
import java.rmi.server.*;
public class AdderRemote extends UnicastRemoteObject implements Adder
{
AdderRemote() throws RemoteException
{
super();
}
public int delexp(int x, int y)
{
    return x-y;
}
public int addinc(int x, int y)
{
    return x+y;
}
public int dbconn(int id)
{
    return id;
}

}