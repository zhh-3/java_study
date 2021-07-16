package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class TestLogin {

    @Test
    public void test(){
        UserDao userDao = new UserDao();
        User login = new User();
        login.setUsername("haha");
        login.setPassword("123456");
        User user = userDao.login(login);
        System.out.println(user);
    }
}
