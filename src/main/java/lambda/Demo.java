package lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-07-03 14:30
 */
public class Demo {

    private static String getInConditionNums(List<Long> params) {
        String joins = params.stream().map(String::valueOf).collect(Collectors.joining(","));
        return joins.length() > 0 ? " in(" + joins + ") " : "in()";
    }

    public static void main(String[] args) {
        List<Long> longList = Lists.newArrayList();
        System.out.println(getInConditionNums(longList));
        List<Long> xx = longList.stream().map(x->x+2L).collect(Collectors.toList());
        System.out.println(xx);
    }
}
