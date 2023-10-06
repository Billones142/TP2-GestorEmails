import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import email.ucp.Dealer;
import email.ucp.User;


public class DealerTest {
    @Test
    public void createUserTest(){// TODO
        assertEquals(true, true);
    }

    @Test
    public void sendEmailTest() throws Exception{// TODO
        Dealer dealer= new Dealer();

        dealer.setNewUser("Stefano Merino", "stefanomerinoderui@gmail.com");
        dealer.setNewUser("Stiven", "stiven@gmail.com");

        dealer.getUser("stefanomerinoderui@gmail.com").addNewContact("stiven", "stiven@gmail.com");

        ArrayList<String> toAddress= new ArrayList<String>();
        toAddress.add(dealer.getUser("stefanomerinoderui@gmail.com").contacts.get(0).getMail());

        dealer.sendMail(dealer.getUser("stefanomerinoderui@gmail.com"), toAddress, "Test", "Hello World", "18 de julio");

        dealer.getUser("stiven@gmail.com").mails.get(0);
        assertEquals(dealer.getUser("stefanomerinoderui@gmail.com").mails.get(0),dealer.getUser("stiven@gmail.com").mails.get(0));
    }
}