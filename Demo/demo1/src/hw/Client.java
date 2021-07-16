package hw;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

public class Client {
    public static void main(String[] args)
    {
        try{
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
            env.put(Context.PROVIDER_URL, "iiop://localhost:1050");
            Context node = new InitialContext(env);
            Object obj = node.lookup("hello");
            Tsum ro = (Tsum) PortableRemoteObject.narrow(obj, Tsum.class);
            System.out.println(ro.sum(20,10));
        }catch(Exception ex){}

    }
}
