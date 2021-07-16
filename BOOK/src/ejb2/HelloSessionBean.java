package ejb2;

import javax.ejb.Stateless;

@Stateless
public class HelloSessionBean implements HelloSessionRemote {
    @Override
    public String hiThere(String name) {
        return "hi there，"+name+"！";
    }
}
