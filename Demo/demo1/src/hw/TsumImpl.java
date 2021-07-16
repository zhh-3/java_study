package hw;

import java.rmi.RemoteException;

public class TsumImpl implements Tsum{
    public TsumImpl(){

    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return (a+b);
    }
}
