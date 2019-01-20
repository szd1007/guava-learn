package refactoring.chp1_starting_point.finalVersion;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public Customer addRental(Rental arg) {
        rentals.add(arg);
        return this;
    }

    public String getName() {
        return name;
    }

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

    double getTotalCharge() {
//        return rentals.stream().collect(Collectors.summarizingDouble(Rental::getCharge)).getSum();
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    /**
     * //todo
     * 这样虽然消除了局部变量， 但是额外增加了循环次数啊
     * //原则， 重构时不要太关心性能损耗，当你进行调优时你往往会在别的地方发现更好的调优点
     * @return
     */
    int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}
