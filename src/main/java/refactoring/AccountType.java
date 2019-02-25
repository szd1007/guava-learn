package refactoring;

public class AccountType {

    /**
     * @see RfMoveField
     */
    private double interestRate;

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public boolean isPremium() {
        return false;
    }


    double overdraftCharge(int daysOverdrawn) {
        if (isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7)
                result += (daysOverdrawn -7) * 0.85;
            return result;
        }else return daysOverdrawn * 1.75;

    }
}
