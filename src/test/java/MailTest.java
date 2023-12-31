import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import email.ucp.Mail;


public class MailTest {
    @Test
    public void mailNotNullTest() throws Exception{
        Mail mail= new Mail("stefanomerinoderui@gmail.com","10 de agosto");

        mail.setSubject("Test");
        mail.setContent("Hello World");
        ArrayList<String> to= new ArrayList<String>();
        to.add("juan@ucp.edu.ar");
        mail.setToAddresses(to);

        assertEquals("stefanomerinoderui@gmail.com", mail.getFrom());
        assertEquals("Test", mail.getSubject());
        assertEquals("Hello World", mail.getContent());
        assertEquals("juan@ucp.edu.ar", mail.getToAddresses().get(0));
    }

    @Test
    public void addToTest() throws Exception{
        Mail mail= new Mail("stefanomerinoderui@gmail.com","10 de agosto");

        mail.setSubject("Test");
        mail.setContent("Hello World");
        ArrayList<String> to= new ArrayList<String>();
        to.add("juan@ucp.edu.ar");
        mail.setToAddresses(to);

        assertEquals("juan@ucp.edu.ar", mail.getToAddresses().get(0));

        mail.addNewToAddress("stiven@ucp.edu.ar");

        assertEquals("juan@ucp.edu.ar", mail.getToAddresses().get(0));
        assertEquals("stiven@ucp.edu.ar", mail.getToAddresses().get(1));
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_1() throws Exception{
        Mail mail= new Mail("stefanomerino.gmail.com", "2 de enero");
        assertNotNull(mail);
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_2() throws Exception{
        Mail mail= new Mail("stefanomerino@", "2 de enero");
        assertNotNull(mail);
    }

    @Test(expected = Exception.class)
    public void invalidMailTest_3() throws Exception{
        Mail mail= new Mail("@gmail.com", "2 de enero");
        assertNotNull(mail);
    }
}