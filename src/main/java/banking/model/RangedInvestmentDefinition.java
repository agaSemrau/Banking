package banking.model;

import javax.persistence.*;
import java.util.*;

@Entity(name="RangedInvestmentDefinition")
@DiscriminatorValue("RID")
public class RangedInvestmentDefinition extends InvestmentDefinition {


    @OneToMany(targetEntity = Range.class, mappedBy = "definition")

    private final List<Range> rangesList = new ArrayList<Range>();


    public RangedInvestmentDefinition(){

    }

    public RangedInvestmentDefinition(String definitionName, List<InvestmentPeriod> investmentPeriodList, List<Currency> currencyList, Date startingDate) {
        super(definitionName, investmentPeriodList, currencyList, startingDate);
        this.rangesList.addAll(rangesList);
        rangesList.sort(new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return Double.compare(o1.getMin(), o2.getMin());
            }
        });
        Collections.reverse(rangesList);
    }


    public boolean isEligible(double ammount, Currency currency, Date openingDate, InvestmentPeriod period){
        boolean result = false;
        for (Range range : rangesList){
            if(ammount>=range.getMin() && currencyList.contains(currency) && (startingDate.compareTo(openingDate)<=0) && investmentPeriodList.contains(period) ){
                result = true;
            }
        }
       return result;
    }

    public double getMatchingRate(double depositAmount){
        double rate = 0;
        for (Range range : rangesList){
            if(range.getMin()>=depositAmount)
            rate = range.getRate();
        }
        return rate;
    }

    public List<Range> getRangesList() {
        return rangesList;
    }


}
