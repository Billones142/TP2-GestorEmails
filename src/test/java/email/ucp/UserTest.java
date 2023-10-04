package email.ucp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import email.ucp.classes.Contact;
import email.ucp.classes.Mail;
import email.ucp.classes.User;

public class UserTest {
    @Test
    public void createUserTest(){
        User usuario= new User("Stefano Merino","stefanomerinoderui@gmail.com");
        assertNotEquals(null , usuario);

        assertEquals("Stefano Merino", usuario.getFullName());
        assertEquals("stefanomerinoderui@gmail.com" , usuario.getDirection());
    }

    @Test
    public void createEmailTest(){
        /*User usuario= new User("stefano","stefanomerinoderui@gmail.com");

        ArrayList<String> to= new ArrayList<String>();
        to.add("alumnado@ucp.edu.ar");

        Mail mail= usuario.createNewEmail("Test", "Hello World", to);

        assertEquals(usuario.getDirection(), mail.getFrom());
        assertEquals("Test", mail.getSubject());
        assertEquals("Hello World", mail.getContent());
        assertEquals(to.get(0), mail.getTo().get(0));*/
    }

    @Test
    public void addNewContactTest(){// TODO
        /*User user= new User("Stefano", "stefanomerinoderui@gmail.com");

        user.addNewContact("juancito", "juancapo@hotmail.com");

        Contact contact= user.contacts.get(0);
        assertEquals("juancito", contact.getName());
        assertEquals("juancapo@hotmail.com", contact.getMail());*/
    }
}