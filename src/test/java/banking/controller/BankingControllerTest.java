package banking.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
public class BankingControllerTest {

    @Autowired
    BankingController bankController;

    @Test
    public void testAddClient() {
        assertTrue(bankController!=null);
        bankController.restAddNewClient("jerzy","kryszak",456465);
        assertTrue(bankController.restFindClient(456465)!=null);
    }


}
