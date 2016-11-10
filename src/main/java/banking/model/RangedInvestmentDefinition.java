package banking.model;

import javax.persistence.*;
import java.util.*;

@Entity(name="RangedInvestmentDefinition")
@Table(name="deposits_definitions")
public class RangedInvestmentDefinition implements InvestmentDefinition {
    @Id
    private String defName = "RangedInvestmentDefinition";

    @ManyToOne(targetEntity = RangedInvestmentDefinition.class)
    @JoinColumn(name = "ranges_list")
    private final List<Range> rangesList = new ArrayList<Range>();

    @Column(name = "currency_list")
    @ElementCollection(targetClass=Currency.class)
    private final List<Currency> currencyList = new ArrayList<Currency>();

    @Column(name = "period_list")
    @ElementCollection(targetClass=InvestmentPeriod.class)
    private final List<InvestmentPeriod> investmentPeriodList = new ArrayList<InvestmentPeriod>();

    @Column(name = "starting_date")
    private final Date startingDate;



    public RangedInvestmentDefinition(List<Currency> currencyList, Date startingDate, List<InvestmentPeriod> investmentPeriodList, List<Range> rangesList) {
        this.currencyList.addAll(currencyList);
        this.startingDate = startingDate;
        this.investmentPeriodList.addAll(investmentPeriodList);
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
            if(ammount>=range.getMin() && currencyList.contains(currency) && (startingDate.compareTo(openingDate)>=0) && investmentPeriodList.contains(period) ){
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
