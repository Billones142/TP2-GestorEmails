package email.ucp;

import static org.junit.Assert.*;

import org.junit.Test;


public class TrayTest {
    @Test
    public void trayTest(){
        Tray bandeja= new Tray("stefanomerinoderui@gmail.com");

        assertNotEquals(null, bandeja);
        assertEquals("stefanomerinoderui@gmail.com", bandeja.getPropietaryDirection());
    }

    @Test
    public void addMailTest(){// TODO
        Tray bandeja= new Tray("stefanomerinoderui@gmail.com");

        Mail mail= new Mail("stefanomerinoderui@gmail.com");
        mail.setSubject("add mail to tray test");

        bandeja.add(mail);


        assertEquals("stefanomerinoderui@gmail.com", mail.getFrom());
        assertEquals("add mail to tray test", mail.getSubject());
    }

    @Test
    public void predicate1Test(){// TODO
        
    }

    @Test
    public void predicate2Test(){// TODO
        
    }

    @Test
    public void predicate3Test(){// TODO
        
    }

    @Test
    public void predicate4Test(){// TODO
        
    }

    @Test
    public void predicate5Test(){// TODO
        
    }
}