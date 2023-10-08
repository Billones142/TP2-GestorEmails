import static org.junit.Assert.*;

import org.junit.Test;

import email.ucp.Contact;

import email.ucp.Mail;
import email.ucp.User;

import java.util.ArrayList;



public class UserTest {
    @Test
    public void createUserTest() throws Exception{
        User usuario= new User("Stefano Merino","stefanomerinoderui@gmail.com");
        assertNotEquals(null , usuario);

        assertEquals("Stefano Merino", usuario.getFullName());
        assertEquals("stefanomerinoderui@gmail.com" , usuario.getEmailAddress());
    }

    @Test
    public void createEmailTest_1() throws Exception{
        User usuario= new User("Stefano Merino","stefanomerinoderui@gmail.com");

        ArrayList<String> to= new ArrayList<String>();
        to.add("alumnado@ucp.edu.ar");

        Mail mail= usuario.createNewEmail("Test", "Hello World", "10 de agosto", to);

        assertEquals(usuario.getEmailAddress(), mail.getFrom());
        assertEquals("Test", mail.getSubject());
        assertEquals("Hello World", mail.getContent());
        assertEquals(to.get(0), mail.getToAddresses().get(0));
        assertEquals("10 de agosto", mail.getDate());
    }

    @Test
    public void createEmailTest_2() throws Exception{
        User usuario= new User("Stefano Merino","stefanomerinoderui@gmail.com");

        usuario.addNewContact("Stiven", "stiven@gmail.com");

        Mail mail= usuario.createNewEmail("Test Mail", "Hello World", "9 de julio", usuario.contacts.get(0));

        assertEquals(usuario.getEmailAddress(), mail.getFrom());
        assertEquals("Test Mail", mail.getSubject());
        assertEquals("Hello World", mail.getContent());
        assertEquals("stiven@gmail.com", mail.getToAddresses().get(0));
        assertEquals("9 de julio", mail.getDate());
    }

    @Test
    public void addNewContactTest() throws Exception{
        User user= new User("Stefano Merino", "stefanomerinoderui@gmail.com");

        user.addNewContact("juancito", "juancapo@hotmail.com");

        Contact contact= user.contacts.get(0);
        assertEquals("juancito", contact.getFullName());
        assertEquals("juancapo@hotmail.com", contact.getEmailAddress());
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_1() throws Exception{
        User user= new User("Stefano Merino", "stefanomerino");
        assertNotNull(user);
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_2() throws Exception{
        User user= new User("Stefano Merino", "stefanomerino@");
        assertNotNull(user);
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_3() throws Exception{
        User user= new User("Stefano Merino", "@gmail.com");
        assertNotNull(user);
    }
}