package refactoring.chp1_starting_point;

import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class CustomerV2 extends Customer {

    public CustomerV2(String name) {
        super(name);
    }

    @Override
    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            //add frequent renter points
//            frequentRenterPoints += rental.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
//            totalAmount += rental.getCharge();;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        String result = "<H1> Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        for (Rental rental : rentals) {
            //show figures for each rental
            result += rental.getMovie().getTitle() + ": " + String.valueOf(rental.getCharge()) + "<BR>\n";
        }
        //add footer lines
        result += "<P> You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM> " + String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    double getTotalCharge() {
//        return rentals.stream().collect(Collectors.summarizingDouble(Rental::getCharge)).getSum();
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    /**
     * //todo
     * 这样虽然消除了局部变量， 但是额外增加了循环次数啊
     * //知道原则， 重构时不要太关心性能损耗，当你进行调优时你往往会在别的地方发现更好的调优点
     * @return
     */
    int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}
