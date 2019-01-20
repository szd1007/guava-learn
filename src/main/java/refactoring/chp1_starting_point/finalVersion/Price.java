package refactoring.chp1_starting_point.finalVersion;

public abstract class Price {
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
    abstract int getPriceCode();
    public abstract double getCharge(int daysRented);
}
