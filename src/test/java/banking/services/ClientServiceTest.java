package banking.services;

import banking.controller.BankingController;
import banking.model.Client;
import banking.model.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@Transactional
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    public void testCreateClient() {
        Client klient = clientService.createClient("Aga", "Lamaga", 123);
        assertEquals(klient.getName(), "Aga");
        assertEquals(klient.getSurname(), "Lamaga");
        assertEquals(klient.getPesel(), 123);
    }

    @Test
    public void testFindClient(){
        Client klient = clientService.createClient("Ola", "Lola", 321);
        Client klientResult = clientService.findClient(321);
        assertEquals(klient, klientResult);
    }

    @Test
    public void testClientNotFound(){
        Client klientResult = clientService.findClient(333);
        assertTrue(klientResult==null);
    }


}
