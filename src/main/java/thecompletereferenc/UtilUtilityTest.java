package thecompletereferenc;

import org.junit.Test;

import java.util.DoubleSummaryStatistics;
import java.util.Objects;
import java.util.StringJoiner;

public class UtilUtilityTest {

    @Test
    public void testDoubleSummaryStatistics() {
        DoubleSummaryStatistics statistics = new DoubleSummaryStatistics();
        statistics.accept(1.0);
        statistics.accept(2.3);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getMin());
    }

    @Test
    public void testObjects() {
        System.out.println(Objects.nonNull(null));
        System.out.println(Objects.isNull(null));
        System.out.println(Objects.hash(11, 33));

    }

    @Test
    public void testStringJoiner() {
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
        stringJoiner.add("111");
        stringJoiner.add("333");
        stringJoiner.add("222");

        System.out.println(stringJoiner);

    }
}
