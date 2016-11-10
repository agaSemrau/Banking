package banking.services;

import banking.model.Account;
import banking.model.Client;
import banking.model.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@Transactional
public class AccountsServiceTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    AccountsService accountsService;

    @Autowired
    ClientService clientService;

    @Test
    public void testOpenAccount() {
        Client newClient = clientService.createClient("Aga", "Lamaga", 123);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 123, 0);
        assertEquals(newAccount.getCurrency(),Currency.EUR);
        assertEquals(newAccount.getClient().getPesel(), 123);
        assertTrue(newAccount.getBalance()== 0);
    }

    @Test
    public void testFindAccount(){
        Client newClient = clientService.createClient("Pola", "Monola", 124);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 124, 0);
        Account accResult = accountsService.findAccount(newAccount.getAccountNumber());
        assertEquals(newAccount, accResult);
    }

    @Test
    public void testFindAccountByPesel(){
        Client newClient = clientService.createClient("Fela", "Pomela", 333);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 333, 22);
        List<Account> accResult = accountsService.findAccountListByPesel(333);
        assertTrue(accResult.contains(newAccount));
        Account result = accResult.get(0);
        assertNotNull(result.getClient());
        Client c = clientService.findClient(333);
        assertTrue(c.getAccountsList().contains(result));
    }

    @Test
    public void testDoNotFindAccountByPesel(){
        List<Account> accResult = accountsService.findAccountListByPesel(444);
        assertTrue(accResult.isEmpty());
    }

    @Test
    public void testDoNotFindAccountByAccNAme(){
        Account account = accountsService.findAccount(12345);
        assertTrue(account == null);
    }



}
