package banking.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Entity(name="StandardInvestmentDefinition")
@Table(name="deposits_definitions")

public class StandardInvestmentDefinition implements InvestmentDefinition {
    @Id
    private String defName = "StandardInvestmentDefinition";

    @Column(name = "rate")
    private static double rate = 0.3;

    @Column(name = "currency_list")
    @ElementCollection(targetClass=Currency.class)
    private final List<Currency> currencyList = new ArrayList<Currency>();

    @Column(name = "period_list")
    @ElementCollection(targetClass=InvestmentPeriod.class)
    private final List<InvestmentPeriod> investmentPeriodList = new ArrayList<InvestmentPeriod>();


    public StandardInvestmentDefinition(List<Currency> currencyList, List<InvestmentPeriod> investmentPeriodList) {
        this.currencyList.addAll(currencyList);
        this.investmentPeriodList.addAll(investmentPeriodList);
    }

    public boolean isEligible(double ammount, Currency currency, Date openingDate, InvestmentPeriod period) {
        boolean result = false;
        if (currencyList.contains(currency) & investmentPeriodList.contains(period)) {
            result = true;
        }

        return result;
    }


    public double getMatchingRate(double depositAmount){
        return rate;
    }

    public static Date setStartStadnardDepositDate() {
        Calendar dataRozpoczeciaPromocji = Calendar.getInstance();
        dataRozpoczeciaPromocji.set(2015, 9, 28, 15, 40);
        return dataRozpoczeciaPromocji.getTime();
    }


}

