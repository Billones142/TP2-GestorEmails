import static org.junit.Assert.*;

import org.junit.Test;

import email.ucp.Dealer;
import email.ucp.User;


public class DealerTest {
    @Test
    public void createUserTest(){// TODO
        assertEquals(true, true);
    }

    @Test
    public void sendEmailTest(){// TODO
        
    }

    @Test(expected = Exception.class)
    public void invalidMailTest(){// TODO
        Dealer dealer= new Dealer();

        dealer.setUsers(new User("Stefano Merino", "gmail.stefanomerinoderui"));
    }
}