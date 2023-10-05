package email.ucp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class MailTest {
    @Test
    public void mailNotNullTest(){
        Mail mail= new Mail("stefanomerinoderui@gmail.com");

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
    public void addToTest(){
        Mail mail= new Mail("stefanomerinoderui@gmail.com");

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
}
