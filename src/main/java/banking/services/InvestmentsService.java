package banking.services;



import banking.exceptions.NoProductDefinitionFoundException;
import banking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Repository
public class InvestmentsService {
    public static final List<Investment> INVESTMENTS_LIST = new ArrayList<Investment>();
    public static final List<InvestmentDefinition> PRODUCT_LIST = new ArrayList<InvestmentDefinition>();
    private static final long LIMIT = 10000000000L;
    private static long accountNumber = 0;

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private ClientService clientService;

    @PersistenceContext
    private EntityManager entityManager;


    static {
        java.util.List<Currency> rangedDepositCurrencies = new ArrayList<Currency>();
        rangedDepositCurrencies.add(Currency.EUR);
        rangedDepositCurrencies.add(Currency.USD);

        java.util.List<Currency> standardDepositCurrencies = new ArrayList<Currency>();
        standardDepositCurrencies.add(Currency.PLN);

        List<InvestmentPeriod> investmentPeriodList = new ArrayList<InvestmentPeriod>();
        investmentPeriodList.add(InvestmentPeriod.ONE_MONTH);
        investmentPeriodList.add(InvestmentPeriod.THREE_MONTHS);
        investmentPeriodList.add(InvestmentPeriod.SIX_MONTHS);

        List<Range> rangesList = new ArrayList<Range>();
        rangesList.add(new Range(1, 0.1));
        rangesList.add(new Range(1000, 0.2));
        rangesList.add(new Range(5000, 0.25));

        PRODUCT_LIST.add(new RangedInvestmentDefinition(rangedDepositCurrencies, setStartPromotionDate(), investmentPeriodList, rangesList));
        PRODUCT_LIST.add(new StandardInvestmentDefinition(standardDepositCurrencies, investmentPeriodList));
    }

    private long nadajNumerKonta() {
        long id = System.currentTimeMillis() % LIMIT;
        if (id <= accountNumber) {
            id = (accountNumber + 1) % LIMIT;
        }
        return accountNumber = id;
    }

    private static Date setStartPromotionDate() {
        Calendar dataRozpoczeciaPromocji = Calendar.getInstance();
        dataRozpoczeciaPromocji.set(2016, 12, 28, 15, 40);
        return dataRozpoczeciaPromocji.getTime();
    }

    public List<Investment> findInvestmentListByPesel(long pesel) {
        return entityManager.createQuery("SELECT i FROM Investment i WHERE i.client LIKE :clientData").setParameter("clientData", clientService.findClient(pesel)).getResultList();
//        Investment theInvestment = null;
//        for (Investment investment : INVESTMENTS_LIST) {
//            if (investment.getClient().getPesel() == pesel) {
//                theInvestment = investment;
//            }
//        }
//        return theInvestment;
    }

    @Transactional
    public Investment openInvestment(long numerKonta, InvestmentPeriod investmentPeriod, double depositAmount) {
        Account konto = accountsService.findAccount(numerKonta);
        Currency currency = konto.getCurrency();

        InvestmentDefinition defToUse = getMatchingDefinition(depositAmount, currency, investmentPeriod);
        Investment newInvestment = openInvestmentUsingDefinition(konto.getCurrency(), nadajNumerKonta(), investmentPeriod, depositAmount, new Date(), defToUse, konto.getClient());

        INVESTMENTS_LIST.add(newInvestment);

        entityManager.persist(newInvestment);
        entityManager.flush();

        return newInvestment;
    }


    private InvestmentDefinition getMatchingDefinition(double depositAmmount, Currency currency, InvestmentPeriod period) {
        InvestmentDefinition defToUse = null;
        for (InvestmentDefinition def : PRODUCT_LIST) {
            if (def.isEligible(depositAmmount, currency, new Date(), period)) {
                defToUse = def;
                break;
            }
        }
        return defToUse;
    }

    private Investment openInvestmentUsingDefinition(Currency depositCurrency, long numerKontaLokaty, InvestmentPeriod czasTrwaniaLokaty, double kwotaLokaty, Date dataZalozeniaLokaty, InvestmentDefinition definition, Client client) {
        if (definition == null) {
            throw new NoProductDefinitionFoundException("Nie udało się");
        }
        Investment newInvestement = new Investment(depositCurrency, numerKontaLokaty, czasTrwaniaLokaty, kwotaLokaty, dataZalozeniaLokaty, definition.getMatchingRate(kwotaLokaty), client);

        return newInvestement;
    }
}


