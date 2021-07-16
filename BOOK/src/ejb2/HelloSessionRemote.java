package ejb2;

import javax.ejb.Remote;

@Remote
public interface HelloSessionRemote {
    String hiThere(String name);
}
