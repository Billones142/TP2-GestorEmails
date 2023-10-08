import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import email.ucp.Mail;
import email.ucp.User;
import email.ucp.Filter;

public class FilterTest {
    @Test
    public void sendPredicateTest() throws Exception{
        User usuario= new User("Stefano Merino", "stefanomerinoderui@gmail.com");
        Filter filtro= new Filter(usuario);

        for (int i = 0; i < 13; i++) {
            usuario.mails.add(i, new Mail("juan@gmail.com","10 de agosto"));
        }
        for (int i = 0; i < 8; i++) {
            usuario.mails.add(i, new Mail("stefanomerinoderui@gmail.com","10 de agosto"));
        }

        ArrayList<Mail> mailsFiltrados= filtro.getEmails_Send().to_EmailList();

        assertEquals(8,mailsFiltrados.size());
    }

    @Test
    public void isFromUcpPredicateTest() throws Exception{
        User usuario= new User("Stefano Merino", "stefanomerinoderui@gmail.com");
        Filter filtro= new Filter(usuario);

        for (int i = 0; i < 3; i++) { //agregar emails recibidos
            usuario.mails.add(i, new Mail("juan"+i+"@ucp.edu.ar","10 de agosto"));
        }
        for (int i = 0; i < 9; i++) { // agregar emails enviados
            usuario.mails.add(i, new Mail("stefanomerinoderui@gmail.com","10 de agosto"));
        }

        ArrayList<Mail> mailsFiltrados= filtro.getEmails_FromUCP().to_EmailList();

        assertEquals(3,mailsFiltrados.size());
    }

    @Test
    public void isFromPredicateTest() throws Exception{
        User usuario= new User("Stefano Merino", "stefanomerinoderui@gmail.com");
        Filter filtro= new Filter(usuario);

        for (int i = 0; i < 13; i++) {
            usuario.mails.add(i, new Mail("juan@gmail.com","10 de agosto"));
        }
        for (int i = 0; i < 12; i++) {
            usuario.mails.add(i, new Mail("juan1@gmail.com", "10 de agosto"));
        }
        for (int i = 0; i < 8; i++) {
            usuario.mails.add(i, new Mail("stefanomerinoderui@gmail.com", "10 de agosto"));
        }

        ArrayList<Mail> mailsFiltrados= filtro.getEmails_From("juan@gmail.com").to_EmailList();

        assertEquals(13,mailsFiltrados.size());
    }

    @Test
    public void datePredicateTest() throws Exception{
        User usuario= new User("Stefano Merino", "stefanomerinoderui@gmail.com");
        Filter filtro= new Filter(usuario);

        for (int i = 0; i < 13; i++) {
            usuario.mails.add(i, new Mail("juan@gmail.com","10 de agosto"));
        }
        for (int i = 0; i < 8; i++) {
            usuario.mails.add(i, new Mail("stefanomerinoderui@gmail.com", "17 de diciembre"));
        }

        ArrayList<Mail> mailsFiltrados= filtro.getEmails_FromDate("17 de diciembre").to_EmailList();

        assertEquals(8,mailsFiltrados.size());
    }
    
    @Test
    public void FiltroComplejoTest() throws Exception{
        User usuario= new User("Stefano Merino", "stefanomerinoderui@gmail.com");
        Filter filtro= new Filter(usuario);

        for (int i = 0; i < 13; i++) {
            usuario.mails.add(i, new Mail("stiven@gmail.com", "8 de septiembre"));
        }
        for (int i = 0; i < 12; i++) {
            usuario.mails.add(i, new Mail("juan@ucp.edu.ar", "20 de diciembre"));
        }
        for (int i = 0; i < 8; i++) {
            usuario.mails.add(i, new Mail("stefanomerinoderui@gmail.com", "24 de enero"));
        }
        for (int i = 0; i < 10; i++) {
            usuario.mails.add(i, new Mail("pedro@ucp.edu.ar", "2 de octubre"));
        }

        ArrayList<Mail> mailsFiltrados= filtro
        .getEmails_FromUCP()
        .getEmails_From("juan@ucp.edu.ar")
        .getEmails_FromDate("20 de diciembre").to_EmailList();

        
        assertEquals(12,mailsFiltrados.size());
    }
}