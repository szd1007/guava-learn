package proxyCache;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Test {



    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("hello world");
//        PrintStream ps=new PrintStream(new FileOutputStream("work"));
//        System.setOut(ps);
//        System.setErr(ps);
        ITest test = new TestImpl();
        Map<String, RedisCache.KeyGen> keyGenMap = Maps.newHashMap();
        test = RedisCache.Factory.getCacheWithinTenMin(Sets.newHashSet("getPerson", "getPersonMap"), test, keyGenMap);
        //取第一参数  然后toString
        keyGenMap.put("getPerson", (RedisCache.KeyGen<String>) arg -> arg);
//
//        System.out.println(test.add(1, 2));
        Map<String, Person> people = test.getPersonMap("adam好");
        Person per = people.get("adam好3");

        System.out.println(per);

    }

}
