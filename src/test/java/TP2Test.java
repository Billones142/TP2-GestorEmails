import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import email.ucp.Dealer;
import email.ucp.Mail;
import email.ucp.User;

public class TP2Test {
    @Test
    public void dealerTest() throws Exception{// TODO
        Dealer dealer= new Dealer();
        ArrayList<String> to= new ArrayList<>();

        dealer.setNewUser("juan", "juanElCaballo@ucp.edu.ar");
        for (int i = 1; i < 3; i++) {
            String address= "juanElCaballo"+i+"@yahoo.org.edu.z";
            dealer.setNewUser("juan"+i, address);
            to.add(address);
        }

        User juan= dealer.getUser("juanElCaballo@ucp.edu.ar");
        
        for (int i = 0; i < 50; i++) {
            dealer.sendMail(juan, to, "Filtro Correcto", "Hello World", "9 de julio");
        }
        for (int i = 0; i < 50; i++) {
            dealer.sendMail(juan, to, "Filtro Incorrecto", "Hello World", "11 de julio");
        }

        ArrayList<Mail> mails= dealer.filter(juan)
        .getEmails_Send()
        .getEmails_FromDate("9 de julio")
        .getEmails_FromUCP()
        .to_EmailList();

        assertEquals( 50, mails.size());
        assertEquals( mails.get(25).getSubject(), "Filtro Correcto");
        assertEquals( mails.get(25).getDate(), "9 de julio");
        assertEquals( mails.get(25).getFrom(), "juanElCaballo@ucp.edu.ar");


        assertEquals(juan.mails.get(0), 
        dealer.getUser(to.get(0)).mails.get(0));

        assertEquals(juan.mails.get(0), 
        dealer.getUser(to.get(1)).mails.get(0));
    }
}
