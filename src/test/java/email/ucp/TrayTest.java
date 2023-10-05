package email.ucp;

import static org.junit.Assert.*;

import org.junit.Test;


public class TrayTest {
    @Test
    public void trayTest(){// TODO
        Tray bandeja= new Tray("stefanomerinoderui@gmail.com");

        assertNotEquals(null, bandeja);
        assertEquals("stefanomerinoderui@gmail.com", bandeja.getPropietaryDirection());
    }

    @Test
    public void holaTest(){
        assertEquals("hola", "hola");
    }
}