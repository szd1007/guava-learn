package refactoring.chp1_starting_point.finalVersion;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author szd1007@github.com
 * @date 2019-01-17 10:03
 */
public class Chp1RefactorTest {

    @Test
    public void testStatement() {
        Customer customer = new Customer("joe");

        String originalRes="Rental Record for joe\n" + "\tchildMovies \t1.5\n" + "\tnormal\t2.0\n" + "\tnew Movies\t9.0\n"
                + "\tnew Movies\t3.0\n" + "Amount owed is 15.5\n" + "You earned 5 frequent renter points";
        Movie child = new Movie("childMovies ", Movie.CHILDRENS);
        Movie normal = new Movie("normal", Movie.REGULAR);
        Movie newMov = new Movie("new Movies", Movie.NEW_RELEASE);

        Rental r1 = new Rental(child, 3);
        Rental r2 = new Rental(normal, 1);
        Rental r3 = new Rental(newMov, 3);
        Rental r4 = new Rental(newMov, 1);

        customer.addRental(r1).addRental(r2).addRental(r3).addRental(r4);

        String res = customer.statement();

        System.out.println(res);
        Assert.assertEquals(originalRes, res);
    }
}
