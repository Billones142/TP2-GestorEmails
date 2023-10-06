import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import email.ucp.Mail;
import email.ucp.User;


public class MailTest {
    @Test
    public void mailNotNullTest() throws Exception{
        Mail mail= new Mail("stefanomerinoderui@gmail.com","10 de agosto");

        mail.setSubject("Test");
        mail.setContent("Hello World");
        ArrayList<String> to= new ArrayList<String>();
        to.add("juan@ucp.edu.ar");
        mail.setTo(to);

        assertEquals("stefanomerinoderui@gmail.com", mail.getFrom());
        assertEquals("Test", mail.getSubject());
        assertEquals("Hello World", mail.getContent());
        assertEquals("juan@ucp.edu.ar", mail.getTo().get(0));
    }

    @Test
    public void addToTest() throws Exception{
        Mail mail= new Mail("stefanomerinoderui@gmail.com","10 de agosto");

        mail.setSubject("Test");
        mail.setContent("Hello World");
        ArrayList<String> to= new ArrayList<String>();
        to.add("juan@ucp.edu.ar");
        mail.setTo(to);

        assertEquals("juan@ucp.edu.ar", mail.getTo().get(0));

        mail.addNewTo("stiven@ucp.edu.ar");

        assertEquals("juan@ucp.edu.ar", mail.getTo().get(0));
        assertEquals("stiven@ucp.edu.ar", mail.getTo().get(1));
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_1() throws Exception{// TODO
        Mail mail= new Mail("stefanomerino.gmail.com", "2 de enero");
        assertNotNull(mail);
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_2() throws Exception{// TODO
        Mail mail= new Mail("stefanomerino@", "2 de enero");
        assertNotNull(mail);
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_3() throws Exception{// TODO
        Mail mail= new Mail("@gmail.com", "2 de enero");
        assertNotNull(mail);
    }
}
