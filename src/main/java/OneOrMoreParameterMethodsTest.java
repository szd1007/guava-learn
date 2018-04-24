import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;

public class OneOrMoreParameterMethodsTest {

    static void test(String... line) {
        Preconditions.checkNotNull(line);
        for (String str : line) {
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("111", "222");
//        test(list); //error
        String[] list2 = new String[] { "111", "222" };
        test(list2);

        test("333");

    }
}
