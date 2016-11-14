package banking.services;

import banking.model.Account;
import banking.model.InvestmentDefinition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductsService {

    @PersistenceContext
    private EntityManager entityManager;


    public List<InvestmentDefinition> getAllProducts() {
        Query q = entityManager.createQuery("Select d from InvestmentDefinition d");
        return q.getResultList();
    }
}
