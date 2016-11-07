package banking.model;

import java.util.Date;

public interface InvestmentDefinition {

    boolean isEligible(double ammount, Currency currency, Date openingDate, InvestmentPeriod period);

    double getMatchingRate(double depositAmount);

}
