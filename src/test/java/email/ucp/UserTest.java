package email.ucp;

import static org.junit.Assert.*;

import org.junit.Test;

import email.ucp.classes.User;

public class UserTest {
    @Test
    public void test(){
        User usuario= new User("stefano","stefanomerinoderui@gmail.com");

        assertNotEquals(null , usuario);
    }
}
