package banking.services;

import banking.model.RangedInvestmentDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@Transactional
public class ProductsServiceTest {
    @Autowired
    ProductsService productsService;

    @PersistenceContext
    EntityManager em;

    @Test
    public void findAllProductsTest(){
       assertFalse(productsService.getAllProducts().isEmpty());
    }

    @Test
    public void getRangeTest() {
        RangedInvestmentDefinition d = (RangedInvestmentDefinition) em.createQuery("select r from RangedInvestmentDefinition r where r.definitionName='RangedInvestmentDefinition'").getSingleResult();
        assertTrue(d.getRangesList().size() == 3);
        assertTrue(d.getCurrencyList().size() == 2);
        assertTrue(d.getInvestmentPeriodList().size() == 3);
    }
}
