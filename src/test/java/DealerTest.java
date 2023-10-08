import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import email.ucp.Dealer;
import email.ucp.Mail;
import email.ucp.User;


public class DealerTest {
    @Test
    public void createUserTest() throws Exception{
        Dealer dealer= new Dealer();

        dealer.setNewUser("Stefano Merino", "stefanomerinoderui@gmail.com");

        assertNotEquals(-1, dealer.getUser("stefanomerinoderui@gmail.com"));
        assertEquals("Stefano Merino", dealer.getUser(0).getFullName());
        assertEquals("stefanomerinoderui@gmail.com", dealer.getUser(0).getEmailAddress());
    }

    @Test
    public void sendEmailTest() throws Exception{
        Dealer dealer= new Dealer();

        dealer.setNewUser("Stefano Merino", "stefanomerinoderui@gmail.com");
        dealer.setNewUser("Stiven", "stiven@gmail.com");

        dealer.getUser("stefanomerinoderui@gmail.com").addNewContact("stiven", "stiven@gmail.com");

        ArrayList<String> toAddress= new ArrayList<String>();
        toAddress.add(dealer.getUser("stefanomerinoderui@gmail.com").contacts.get(0).getMailAddress());

        dealer.sendMail(dealer.getUser("stefanomerinoderui@gmail.com"), toAddress, "Test", "Hello World", "18 de julio");

        dealer.getUser("stiven@gmail.com").mails.get(0);
        assertEquals(dealer.getUser("stefanomerinoderui@gmail.com").mails.get(0),dealer.getUser("stiven@gmail.com").mails.get(0));
    }

    @Test
    public void filterFromDealerTest() throws Exception{
        Dealer dealer= new Dealer();

        dealer.setNewUser("Stefano Merino", "stefanomerinoderui@gmail.com");

        User usuario=  dealer.getUser("stefanomerinoderui@gmail.com");
        for (int i = 0; i < 13; i++) {
            usuario.mails.add(i, new Mail("stiven@gmail.com", "8 de septiembre"));
        }
        for (int i = 0; i < 6; i++) {
            usuario.mails.add(i, new Mail("juan@ucp.edu.ar", "20 de diciembre"));
        }
        for (int i = 0; i < 11; i++) {
            usuario.mails.add(i, new Mail("stefanomerinoderui@gmail.com", "24 de enero"));
        }
        for (int i = 0; i < 9; i++) {
            usuario.mails.add(i, new Mail("pedro@ucp.edu.ar", "2 de octubre"));
        }

        ArrayList<Mail> mailsFiltrados= dealer.filter(dealer.getUser("stefanomerinoderui@gmail.com"))
        .getEmails_FromUCP()
        .getEmails_From("juan@ucp.edu.ar")
        .getEmails_FromDate("20 de diciembre")
        .to_EmailList();

        assertEquals(6, mailsFiltrados.size());
    }

    @Test(expected = Exception.class)
    public void searhNullUserTest() throws Exception{
        Dealer dealer= new Dealer();

        dealer.setNewUser("Stefano Merino", "stefanomerinoderui@gmail.com");

        assertEquals(-1, dealer.getUser("stiven@gmail.com"));
    }
}