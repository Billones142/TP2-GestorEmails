package email.ucp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import email.ucp.classes.Mail;
import email.ucp.classes.User;

public class UserTest {
    @Test
    public void createUserTest(){// TODO
        User usuario= new User("Stefano Merino","stefanomerinoderui@gmail.com");
        assertNotEquals(null , usuario);

        assertEquals("Stefano", usuario.getFullName());
        assertEquals("stefanomerinoderui@gmail.com" , usuario.getDirection());
    }

    @Test
    public void sendEmailTest(){
        User usuario= new User("stefano","stefanomerinoderui@gmail.com");

        ArrayList<String> to= new ArrayList<String>();
        to.add("alumnado@ucp.edu.ar");

        
    }
}