package refactoring.chp1_starting_point;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    double getCharge() {
        double result = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3) {
                    String a;
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRenterPoints() {
        int result = 1;
        //add bonus for a two day new release rental
        if ((movie.getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            result++;
        }
        return result;
    }
}
