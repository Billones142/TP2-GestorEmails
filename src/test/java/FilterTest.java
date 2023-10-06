import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import email.ucp.Mail;
import email.ucp.Filter;

public class FilterTest {
    @Test
    public void sendPredicateTest() throws Exception{
        ArrayList<Mail> mails= new ArrayList<Mail>();
        Filter filtro= new Filter();

        for (int i = 0; i < 13; i++) {
            mails.add(i, new Mail("juan@gmail.com","10 de agosto"));
        }
        for (int i = 0; i < 8; i++) {
            mails.add(i, new Mail("stefanomerinoderui@gmail.com","10 de agosto"));
        }

        ArrayList<Mail> mailsFiltrados= filtro.getFilteredMails_Send(mails, "stefanomerinoderui@gmail.com");

        assertEquals(8,mailsFiltrados.size());
    }

    @Test
    public void isFromUcpPredicateTest() throws Exception{// TODO
        ArrayList<Mail> mails= new ArrayList<Mail>();
        Filter filtro= new Filter();

        for (int i = 0; i < 3; i++) { //agregar emails recibidos
            mails.add(i, new Mail("juan"+i+"@ucp.edu.ar","10 de agosto"));
        }
        for (int i = 0; i < 9; i++) { // agregar emails enviados
            mails.add(i, new Mail("stefanomerinoderui@gmail.com","10 de agosto"));
        }

        ArrayList<Mail> mailsFiltrados= filtro.getFilteredMails_FromUCP(mails);

        assertEquals(3,mailsFiltrados.size());
    }

    @Test
    public void isFromPredicateTest() throws Exception{// TODO
        ArrayList<Mail> mails= new ArrayList<Mail>();
        Filter filtro= new Filter();

        for (int i = 0; i < 13; i++) {
            mails.add(i, new Mail("juan@gmail.com","10 de agosto"));
        }
        for (int i = 0; i < 12; i++) {
            mails.add(i, new Mail("juan1@gmail.com", "10 de agosto"));
        }
        for (int i = 0; i < 8; i++) {
            mails.add(i, new Mail("stefanomerinoderui@gmail.com", "10 de agosto"));
        }

        ArrayList<Mail> mailsFiltrados= filtro.getFilteredMails_From(mails, "juan@gmail.com");

        assertEquals(13,mailsFiltrados.size());
    }
    
    @Test
    public void FiltroComplejoTest() throws Exception{// TODO
        ArrayList<Mail> mails= new ArrayList<Mail>();
        Filter filtro= new Filter();

        for (int i = 0; i < 13; i++) {
            mails.add(i, new Mail("juan@gmail.com", "10 de agosto"));
        }
        for (int i = 0; i < 12; i++) {
            mails.add(i, new Mail("juan1@gmail.com", "10 de agosto"));
        }
        for (int i = 0; i < 8; i++) {
            mails.add(i, new Mail("stefanomerinoderui@gmail.com", "10 de agosto"));
        }

        ArrayList<Mail> mailsFiltrados= filtro.getFilteredMails_From(mails, "juan@gmail.com");

        assertEquals(13,mailsFiltrados.size());
    }
}
