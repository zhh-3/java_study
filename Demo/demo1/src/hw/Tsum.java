package hw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Tsum extends Remote {
    public int sum(int a,int b) throws RemoteException;
}
