package banking.services;

import banking.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@Transactional
public class InvestmentsServiceTest {
    @Autowired
    InvestmentsService investmentsService;

    @Autowired
    ClientService clientService;

    @Autowired
    AccountsService accountsService;

    @Test
    public void testOpenInvestment(){
        Client newClient = clientService.createClient("Aga", "Lamaga", 123);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 123, 0);
        Investment newInvestment = investmentsService.openInvestment(newAccount.getAccountNumber(), InvestmentPeriod.ONE_MONTH, 3000);
        assertEquals(newInvestment.getClient().getPesel(), 123);
        assertEquals(newInvestment.getCurrency(), Currency.EUR );
        assertEquals(newInvestment.getInvestmentPeriod(), InvestmentPeriod.ONE_MONTH);
        assertTrue(newInvestment.getKwotaLokaty() == 3000);
    }

    @Test
    public void testFindInvestmentByPesel(){
        Client newClient = clientService.createClient("Aga", "Blebla", 333);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 333, 0);
        Investment newInvestment = investmentsService.openInvestment(newAccount.getAccountNumber(), InvestmentPeriod.THREE_MONTHS, 1000);
        List<Investment> invResult = investmentsService.findInvestmentListByPesel(333);
        assertTrue(invResult.contains(newInvestment));
    }

    @Test
    public void testNotFindInvestmentByPesel(){
        List<Investment> invResult = investmentsService.findInvestmentListByPesel(434);
        assertTrue(invResult.isEmpty());
    }

}
